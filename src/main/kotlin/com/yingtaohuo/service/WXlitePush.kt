package com.yingtaohuo.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.mall.AllOpen
import com.mall.model.Order
import com.mall.push.pusher.BaiduMqttPusher
import com.mall.service.CorpService
import com.mall.service.UserService
import com.mall.utils.NumberUtil
import com.mall.utils.Util
import com.qq.weixin.wx3rd.TemplateMsg
import com.qq.weixin.wx3rd.TemplateMsgDataEntry
import com.yingtaohuo.mode.Coupon
import com.yingtaohuo.wxmsg.WXMsgClient
import org.springframework.stereotype.Service
import java.time.Duration
import java.time.Instant
import javax.annotation.PreDestroy

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/15
 * 微信: yin80871901
 */

data class WXLiteEventPayLoad(val orderId: Int)

data class WXLiteEvent(val type: Int, val status: Int, val data: Any)

@AllOpen
@Service
class WXLiteMQTTPush(private val wxlitePush: BaiduMqttPusher,
                      private val userService: UserService,
                      private val objectMapper: ObjectMapper) {

    @PreDestroy
    fun destroy() {
        wxlitePush.destroy()
    }

    private val Type_OrderStateChange = 1

    fun topic(openid: String) : String = "wxlite/$openid"

    // 订单已支付
    // 状态推送到用户小程序
    fun orderPaid(userId: Int, orderId: Int) {
        val openId = userService.selectUser(userId).openid
        val payload = objectMapper.writeValueAsString(WXLiteEvent(Type_OrderStateChange, Order.STATUS_PAID, WXLiteEventPayLoad(orderId)))
        wxlitePush.pushToClient(topic(openId), payload, null)
    }

}

@AllOpen
@Service
class WXMsgPush(private val wxMsgClient: WXMsgClient, private val corpService: CorpService, private val shopWXMsgService: ShopWXMsgService, private val userService: UserService) {

    /**
     * 向用户推送订单支付成功
     * 重点显示金额
     * 消费金额 {{keyword1.DATA}}
     * 联系人 {{keyword2.DATA}}
     * 备注 {{keyword3.DATA}}
     * 物品名称 {{keyword4.DATA}}
     * 地址 {{keyword5.DATA}}
     * 电话 {{keyword6.DATA}}
     * 售后客服 {{keyword7.DATA}}
     * 订单号 {{keyword8.DATA}}
     */
    fun pushOrderPaid(pushKey: String, target: String, order: Order) {

        val shop = corpService.resolveWxMsgShop(order.corpId)

        val tplMsg = shopWXMsgService.getTplMsgTypeByRangeOfShop(when (order.orderType) {
            Order.ORDER_TYPE_DELIVERED -> TplMessageTypeOfBuyNotifyWithDelivery
            else -> TplMessageTypeOfBuyNotify
        }, shop.id)

        if ( tplMsg != null ) {

            val appid = shop.authorizerAppid

            val msg = TemplateMsg(
                    target, tplMsg.templateId,
                    page = "pages/orderList/orderList?orderId=${order.id}", formId = pushKey,
                    emphasisKeyword = "keyword1.DATA",
                    data = null
            )

            val data = hashMapOf<String, TemplateMsgDataEntry>()

            if (order.orderType == Order.ORDER_TYPE_DELIVERED) {

                // 消费金额 {{keyword1.DATA}}
                data.put("keyword1", TemplateMsgDataEntry(NumberUtil.fenToYuan2(order.payAmount), null))
                // 备注 {{keyword2.DATA}}
                data.put("keyword2", TemplateMsgDataEntry(order.remark, null))
                // 物品名称 {{keyword3.DATA}}
                data.put("keyword3", TemplateMsgDataEntry(order.orderItemNames, null))

                val address = order.address
                if ( address != null ) {
                    // 地址 {{keyword4.DATA}}
                    data.put("keyword4", TemplateMsgDataEntry(address.address, null))
                    // 联系人 {{keyword5.DATA}}
                    data.put("keyword5", TemplateMsgDataEntry(address.linkman, null))
                    // 电话 {{keyword6.DATA}}
                    data.put("keyword6", TemplateMsgDataEntry(address.phone, null))
                }
                // 售后客服 {{keyword7.DATA}}
                data.put("keyword7", TemplateMsgDataEntry(shop.corpPhone, null))

                // 订单号 {{keyword8.DATA}}
                data.put("keyword8", TemplateMsgDataEntry(order.orderCode, null))

            } else {

                // 消费金额 {{keyword1.DATA}}
                data.put("keyword1", TemplateMsgDataEntry(NumberUtil.fenToYuan2(order.payAmount), null))
                // 备注 {{keyword2.DATA}}
                data.put("keyword2", TemplateMsgDataEntry(order.remark ?: "无", null))
                // 物品名称 {{keyword3.DATA}}
                data.put("keyword3", TemplateMsgDataEntry(order.orderItemNames, null))
                // 订单号 {{keyword4.DATA}}
                data.put("keyword4", TemplateMsgDataEntry(order.orderCode, null))
            }

            msg.data = data

            wxMsgClient.sendMsg(appid, msg)
        }

    }

    /**
     * 向用户推送卡券提醒
     * 重点显示金额
     * 服务名称 {{keyword1.DATA}}
     * 过期时间 {{keyword2.DATA}}
     * 温馨提示 {{keyword3.DATA}}
     */
    fun pushCouponAlert(pushKey: String, target: String, coupon: Coupon) {

        val shop = corpService.selectCorpByCorpId(coupon.shopId)

        val tplMsg = shopWXMsgService.getTplMsgTypeByRangeOfShop(TplMessageTypeOfCoupon, coupon.shopId)

        if ( tplMsg != null ) {
            val appid = shop.authorizerAppid

            val msg = TemplateMsg(
                    target, tplMsg.templateId,
                    page = "pages/couponDetail/couponDetail?couponId=${coupon.id}", formId = pushKey,
                    emphasisKeyword = "keyword1.DATA",
                    data = null
            )

            val data = hashMapOf<String, TemplateMsgDataEntry>()

            data.put("keyword1", TemplateMsgDataEntry(coupon.typeText!!, null))
            data.put("keyword2", TemplateMsgDataEntry(Util.dateFormat(coupon.expirationTime!!), null))

            val day = Duration.between(Instant.now(), coupon.expirationTime.toInstant()).toDays()

            if ( coupon.cutback > 0 ) {
                data.put("keyword3", TemplateMsgDataEntry("现在下单立减${(coupon.cutback / 100.0).toFloat()}元，快去下单吧，${day}天后就过期了", null))
            }
            else if ( coupon.discount > 0 ) {
                data.put("keyword3", TemplateMsgDataEntry("现在下单立享${coupon.discount * 10}折优惠，快去下单吧，${day}天后就过期了", null))
            }
            else {
                data.put("keyword3", TemplateMsgDataEntry("快去下单吧，${day}天后就过期了", null))
            }

            msg.data = data

            wxMsgClient.sendMsg(appid, msg)

        }
    }

}
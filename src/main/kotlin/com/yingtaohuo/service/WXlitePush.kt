package com.yingtaohuo.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.mall.model.Order
import com.mall.push.pusher.BaiduMqttPusher
import com.mall.service.CorpService
import com.mall.service.UserService
import com.mall.utils.NumberUtil
import com.qq.weixin.wx3rd.TemplateMsg
import com.qq.weixin.wx3rd.TemplateMsgDataEntry
import com.yingtaohuo.wxmsg.WXMsgClient
import org.springframework.stereotype.Service
import javax.annotation.PreDestroy

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/15
 * 微信: yin80871901
 */

data class WXLiteEventPayLoad(val orderId: Int)

data class WXLiteEvent(val type: Int, val status: Int, val data: Any)

@Service
open class WXLiteMQTTPush(private val wxlitePush: BaiduMqttPusher,
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

@Service
open class WXMsgPush(private val wxMsgClient: WXMsgClient, private val corpService: CorpService, private val shopWXMsgService: ShopWXMsgService, private val userService: UserService) {

    /**
     * 向用户推送订单支付成功
     * 重点显示金额
     * 消费金额 {{keyword1.DATA}}
     * 联系人 {{keyword2.DATA}}
        备注 {{keyword3.DATA}}
        物品名称 {{keyword4.DATA}}
        地址 {{keyword5.DATA}}
        电话 {{keyword6.DATA}}
        售后客服 {{keyword7.DATA}}
        订单号 {{keyword8.DATA}}
     */
    fun pushOrderPaid(order: Order) {

        if (order.prepayId == null) {
            return
        }
        val user = userService.selectUser(order.userId)
        val shop = corpService.selectCorpByCorpId(order.corpId)
        val tplMsgs = shopWXMsgService.getTplMsgRangeOfShop(order.corpId)
        val appid = shop.authorizerAppid

        if (tplMsgs.isEmpty()) {
            return
        }

        val tplMsg = tplMsgs[0]

        val msg = TemplateMsg(
                user.openid, tplMsg.templateId,
                page = "pages/orderList/orderList", formId = order.prepayId,
                emphasisKeyword = "keyword1.DATA",
                data = null
        )

        val data = hashMapOf<String, TemplateMsgDataEntry>()

        // 消费金额 {{keyword1.DATA}}
        data.put("keyword1.DATA", TemplateMsgDataEntry(NumberUtil.fenToYuan2(order.payAmount), null))
        // 备注 {{keyword2.DATA}}
        data.put("keyword2.DATA", TemplateMsgDataEntry(order.remark, null))
        // 物品名称 {{keyword3.DATA}}
        data.put("keyword3.DATA", TemplateMsgDataEntry(order.orderItemNames, null))

        if (order.orderType == Order.ORDER_TYPE_DELIVERED) {
            val address = order.address
            if ( address != null ) {
                // 地址 {{keyword4.DATA}}
                data.put("keyword4.DATA", TemplateMsgDataEntry(address.address, null))
                // 联系人 {{keyword5.DATA}}
                data.put("keyword5.DATA", TemplateMsgDataEntry(address.linkman, null))
                // 电话 {{keyword6.DATA}}
                data.put("keyword6.DATA", TemplateMsgDataEntry(address.phone, null))
            }
            // 售后客服 {{keyword7.DATA}}
            data.put("keyword7.DATA", TemplateMsgDataEntry(shop.corpPhone, null))
        }

        // 订单号 {{keyword8.DATA}}
        data.put("keyword8.DATA", TemplateMsgDataEntry(order.orderCode, null))

        msg.data = data

        wxMsgClient.sendMsg(appid, msg)
    }

}
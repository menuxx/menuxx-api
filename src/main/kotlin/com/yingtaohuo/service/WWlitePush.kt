package com.yingtaohuo.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.mall.model.Order
import com.mall.push.pusher.BaiduMqttPusher
import com.mall.service.UserService
import org.springframework.stereotype.Service
import javax.annotation.PreDestroy

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/15
 * 微信: yin80871901
 */

data class WxLiteEventPayLoad(val orderId: Int)

data class WxliteEvent(val type: Int, val status: Int, val data: Any)

@Service
open class WxlitePush(val wxlitePush: BaiduMqttPusher,
                      val userService: UserService,
                      val objectMapper: ObjectMapper) {

    @PreDestroy
    fun destroy() {
        wxlitePush.destroy()
    }

    val Type_OrderStateChange = 1

    fun topic(openid: String) : String = "wxlite/$openid"

    // 订单已支付
    // 状态推送到用户小程序
    fun orderPaid(userId: Int, orderId: Int) {
        val openId = userService.selectUser(userId).openid
        val payload = objectMapper.writeValueAsString(WxliteEvent(Type_OrderStateChange, Order.STATUS_PAID, WxLiteEventPayLoad(orderId)))
        wxlitePush.pushToClient(topic(openId), payload, null)
    }

}
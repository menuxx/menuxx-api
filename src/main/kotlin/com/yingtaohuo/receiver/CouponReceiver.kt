package com.yingtaohuo.receiver

import com.mall.AllOpen
import com.mall.service.UserService
import com.rabbitmq.client.Channel
import com.yingtaohuo.mode.Coupon
import com.yingtaohuo.service.CouponService
import com.yingtaohuo.service.PushKeyService
import com.yingtaohuo.service.WXMsgPush
import org.springframework.amqp.rabbit.annotation.*
import org.springframework.amqp.support.AmqpHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/29
 * 微信: yin80871901
 * 卡券消费提醒消息处理
 */

@Component
@AllOpen
@RabbitListener(
        containerFactory = "rabbitListenerContainerFactory",
        bindings = arrayOf(
                QueueBinding(
                        value = Queue(value = "coupon_alert", durable = "true", autoDelete = "false"),
                        exchange = Exchange(
                                value = "yth.delay",
                                type = "headers",
                                durable = "true",
                                delayed = "true",
                                arguments = arrayOf(
                                        Argument(name = "x-delayed-type", value = "direct"))
                                ),
                        key = "coupon_alert.delay"
                )
        )
)
class CouponReceiver(
        private val wxPush: WXMsgPush,
        private val pushKeyService: PushKeyService,
        private val couponService: CouponService,
        private val userService: UserService
        ) {

    /**
     * 处理 卡券推送
     */
    @RabbitHandler
    open fun handleCouponPush(@Payload couponMsg: Coupon, channel: Channel, @Header(AmqpHeaders.DELIVERY_TAG) deliveryTag: Long) {
        // 从 用户的 池中获取一个可用的 push_key
        val pushKey = pushKeyService.getUserAvailableKey(couponMsg.userId)
        // 如果没有 push key 就丢弃该消息, 防止造成死循环
        if ( pushKey == null ) {
            channel.basicAck(deliveryTag, false)
        } else {
            val user = userService.selectUser(couponMsg.userId)
            val couponOfDb =  couponService.getMyCoupon(couponMsg.userId, couponMsg.id)
            // 当卡券没有消费，就推送消息
            if ( couponOfDb.used != 1 ) {
                // 记录消息key使用次数
                pushKeyService.timesIncrementByKeyId(pushKey.id)
                wxPush.pushCouponAlert(pushKey.pushKey, user.openid, couponMsg)
            }
        }
    }

}

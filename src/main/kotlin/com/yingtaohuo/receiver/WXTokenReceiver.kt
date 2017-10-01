package com.yingtaohuo.receiver

import com.mall.service.WXComponentService
import com.rabbitmq.client.AMQP
import com.rabbitmq.client.Channel
import com.yingtaohuo.configure.WXComponentToken
import org.slf4j.LoggerFactory
import org.springframework.amqp.core.ExchangeTypes
import org.springframework.amqp.rabbit.annotation.*
import org.springframework.amqp.support.AmqpHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import java.io.IOException

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/30
 * 微信: yin80871901
 *
 * @RabbitListener(containerFactory = "rabbitListenerContainerFactory", bindings = @QueueBinding(
 * value = @Queue(value = "${mq.config.queue}", durable = "true"),
 * exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.TOPIC),
 * key = "${mq.config.key}"), admin = "rabbitAdmin")
 */
@Component
@RabbitListener(
        containerFactory = "rabbitListenerContainerFactory",
        bindings = arrayOf(
                QueueBinding(
                        value = Queue(value = "sys_order", durable = "true"),
                        exchange = Exchange(value = "wxtoken", type = ExchangeTypes.FANOUT, durable = "true"),
                        key = "component_token"
                ),
                QueueBinding(
                        value = Queue(value = "sys_order_test", durable = "true"),
                        exchange = Exchange(value = "wxtoken", type = ExchangeTypes.FANOUT, durable = "true"),
                        key = "component_token"
                )
        )
)
open class WXTokenReceiver(private val componentService: WXComponentService) {

    private val logger = LoggerFactory.getLogger(WXTokenReceiver::class.java)

    // 当有 token 被更新的时候 就更新
    @RabbitHandler
    @Throws(InterruptedException::class, IOException::class)
    open fun receiveWXToken(@Payload token: WXComponentToken, channel: Channel, @Header(AmqpHeaders.DELIVERY_TAG) deliveryTag: Long) {
        logger.debug("=== receiveMessage componentAccessToken : ${token.componentAccessToken}")
        componentService.accessToken = token.componentAccessToken
    }

}
package com.yingtaohuo.configure

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory
import org.springframework.messaging.converter.MappingJackson2MessageConverter
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter


/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/22
 * 微信: yin80871901
 */

data class WXComponentToken (
        @JsonProperty("component_access_token") val componentAccessToken: String,
        @JsonProperty("expires_in") val expiresIn: Int
)

open class Publisher(private val template: RabbitTemplate) {

    fun sendDelay(exchange: String, routingKey: String, data: Any, delayOfSeconds: Int) {
        // exchange , routingKey, msg
        template.convertAndSend(exchange, routingKey, data, { msg ->
            msg.messageProperties.delay = delayOfSeconds * 1000
            msg
        })
    }

}

@Configuration
open class RabbitConfigure(val objectMapper: ObjectMapper) : RabbitListenerConfigurer {

    @Bean
    open fun rabbitListenerContainerFactory(connectionFactory: ConnectionFactory): SimpleRabbitListenerContainerFactory {
        val factory = SimpleRabbitListenerContainerFactory()
        factory.setConnectionFactory(connectionFactory)
        factory.setDefaultRequeueRejected(true)
        factory.setMaxConcurrentConsumers(10)
        factory.setMessageConverter(Jackson2JsonMessageConverter(objectMapper))
        return factory
    }

    @Bean
    open fun wxTokenQueue(): Queue {
        return Queue("sys_order", true)
    }

    @Bean
    open fun couponAlertQueue(): Queue {
        return Queue("coupon_alert", true)
    }

    @Bean
    open fun ythExchange() : Exchange {
        return DelayedExchange("yth.delay", true, false, mutableMapOf("x-delayed-type" to "direct"))
    }

    @Bean
    open fun wxTokenExchange(): FanoutExchange {
        return FanoutExchange("wxtoken", true, false)
    }

    @Bean
    open fun rabbitTemplate(connectionFactory: ConnectionFactory): RabbitTemplate {
        val template = RabbitTemplate(connectionFactory)
        template.messageConverter = Jackson2JsonMessageConverter(objectMapper)
        return template
    }

    @Bean
    open fun delayPublisher(rabbitTemplate: RabbitTemplate) : Publisher {
        return Publisher(rabbitTemplate)
    }

    @Bean
    open fun jackson2Converter(): MappingJackson2MessageConverter {
        val converter = MappingJackson2MessageConverter()
        converter.objectMapper = objectMapper
        return converter
    }

    @Bean
    open fun myHandlerMethodFactory(): DefaultMessageHandlerMethodFactory {
        val factory = DefaultMessageHandlerMethodFactory()
        factory.setMessageConverter(jackson2Converter())
        return factory
    }

    override fun configureRabbitListeners(registrar: RabbitListenerEndpointRegistrar) {
        registrar.messageHandlerMethodFactory = myHandlerMethodFactory()
    }

}
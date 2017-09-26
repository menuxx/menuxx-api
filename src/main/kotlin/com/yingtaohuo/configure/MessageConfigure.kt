package com.yingtaohuo.configure

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.mall.configure.properties.AppConfigureProperties
import com.mall.service.WXComponentService
import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/22
 * 微信: yin80871901
 */

data class WXComponentToken(
        @JsonProperty("component_access_token") val componentAccessToken: String,
        @JsonProperty("expires_in") val expiresIn: Int
)

@Component
open class WXTokenReceiver(val objectMapper: ObjectMapper, val componentService: WXComponentService) {

    // 当有 token 被更新的时候 就更新
    open fun receiveMessage(message: ByteArray) {
        val token = objectMapper.readValue<WXComponentToken>(message, WXComponentToken::class.java)
        println("=== receiveMessage componentAccessToken : ${token.componentAccessToken}")
        componentService.accessToken = token.componentAccessToken
    }

}

@Configuration
open class MessageConfigure (private val appConfig: AppConfigureProperties) {

    @Bean
    open fun wxTokenQueue(): Queue {
        return Queue(appConfig.message.updateComponentTokenQueue, true)
    }

    @Bean
    open fun wxTokenExchange(): FanoutExchange {
        return FanoutExchange("wxtoken", true, false)
    }

    @Bean
    open fun sysOrderQueueBindToWXTokenExchange(queue: Queue, exchange: FanoutExchange): Binding {
        return BindingBuilder.bind(queue).to(exchange)
    }

    @Bean
    open fun wxTokenListenerAdapter(receiver: WXTokenReceiver): MessageListenerAdapter {
        return MessageListenerAdapter(receiver, "receiveMessage")
    }

    @Bean
    open fun container(connectionFactory: ConnectionFactory,
                           listenerAdapter: MessageListenerAdapter): SimpleMessageListenerContainer {
        val container = SimpleMessageListenerContainer()
        container.connectionFactory = connectionFactory
        container.setQueueNames(appConfig.message.updateComponentTokenQueue)
        container.messageListener = listenerAdapter
        return container
    }

}
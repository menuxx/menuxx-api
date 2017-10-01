package com.yingtaohuo.configure

import org.springframework.amqp.core.AbstractExchange

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/30
 * 微信: yin80871901
 */
open class DelayedExchange(name: String?, durable: Boolean, autoDelete: Boolean, arguments: MutableMap<String, Any>?) : AbstractExchange(name, durable, autoDelete, arguments) {

    override fun getType() = "x-delayed-message"

}
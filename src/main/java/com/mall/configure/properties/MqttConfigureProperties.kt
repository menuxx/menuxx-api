package com.mall.configure.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("mqtt.order")
open class MqttOrderConfigureProperties {

    var broker: String? = null

    var password: String? = null

    var username: String? = null

    var timeout: Int = 0

    var keepalive: Int = 0

}


@Configuration
@ConfigurationProperties("mqtt.wxlite")
open class MqttWxLiteConfigureProperties {

    var broker: String? = null

    var password: String? = null

    var username: String? = null

    var timeout: Int = 0

    var keepalive: Int = 0

}
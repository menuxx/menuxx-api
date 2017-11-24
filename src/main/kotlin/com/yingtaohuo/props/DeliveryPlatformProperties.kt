package com.yingtaohuo.props

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.stereotype.Component

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/7
 * 微信: yin80871901
 */
@Component
@ConfigurationProperties("delivery-platform")
class DeliveryPlatformProperties {

    @NestedConfigurationProperty
    var ele: Ele? = null

    @NestedConfigurationProperty
    var imdada: ImDada? = null

}

open class Ele {
    var appId: String = ""
    var secretKey: String = ""
    var callbackUrl: String = ""
}


open class ImDada {
    var appKey: String = ""
    var appSecret: String = ""
    var callbackUrl: String = ""
}

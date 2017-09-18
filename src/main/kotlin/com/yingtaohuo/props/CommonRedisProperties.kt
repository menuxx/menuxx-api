package com.yingtaohuo.props

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/13
 * 微信: yin80871901
 */

@ConfigurationProperties(prefix = "spring.redis.common")
@Configuration
open class CommonRedisProperties {

    var timeout: Int = 0
    var database: Int = 0
    var host: String? = null
    var port: Int = 0
    var password: String? = null

    @NestedConfigurationProperty
    var pool: Pool? = null
}

open class Pool {
    var maxActive: Int = 0
    var maxWait: Int = 0
    var maxIdle: Int = 0
    var minIdle: Int = 0
}
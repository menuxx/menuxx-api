package com.yingtaohuo.props

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/7
 * 微信: yin80871901
 */
@Component
@ConfigurationProperties("imdada")
class ImDadaProperties {
    lateinit var appKey: String
    lateinit var appSecret: String
}
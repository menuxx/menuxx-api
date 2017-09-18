package com.yingtaohuo.configure

import com.fasterxml.jackson.databind.ObjectMapper
import com.qq.weixin.wx3rd.WXMessageApi
import com.qq.weixin.wx3rd.WXMessageClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/13
 * 微信: yin80871901
 */
@Configuration
open class WXApiConfigure {

    @Bean
    open fun wxMsgClient(objectMapper: ObjectMapper) : WXMessageApi {
        return WXMessageClient().build(objectMapper)
    }

}
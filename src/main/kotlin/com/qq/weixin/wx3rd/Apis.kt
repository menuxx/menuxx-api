package com.qq.weixin.wx3rd

import feign.Param
import feign.RequestLine

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/13
 * 微信: yin80871901
 */

interface WXMessageApi {

    // https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET

    // https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN
    @RequestLine("POST /message/wxopen/template/send?access_token={accessToken}")
    @Throws(WXException::class)
    fun sendMessage(@Param("accessToken") accessToken: String, msg: TemplateMsg) : WXResult

}
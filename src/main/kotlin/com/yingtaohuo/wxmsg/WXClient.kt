package com.yingtaohuo.wxmsg

import com.qq.weixin.wx3rd.TemplateMsg
import com.qq.weixin.wx3rd.WXMessageApi
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/13
 * 微信: yin80871901
 */

@Service
class WXMsgClient(
        private val wxMsgApi: WXMessageApi,
        private val tokenClient: WXAuthorizerAccessTokenClient
) {
    fun sendMsg(appId: String, msg: TemplateMsg) {
        val accessToken = tokenClient.getToken(appId)
        if ( accessToken != null ) {
            wxMsgApi.sendMessage(accessToken, msg)
        }
    }
}

@Service
open class WXAuthorizerAccessTokenClient(
        @Qualifier("commonRedisTemplate")
        private val redisTemplate: RedisTemplate<String, Any>
) {

    @SuppressWarnings("unchecked")
    open fun getToken(appId: String) : String? {
        val tokens = redisTemplate.opsForValue().get("authorizer_token:$appId") as Map<String, String>
        return tokens["authorizer_access_token"]
    }

}
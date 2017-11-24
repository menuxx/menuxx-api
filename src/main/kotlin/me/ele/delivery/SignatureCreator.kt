package me.ele.delivery

import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.lang3.StringUtils
import org.slf4j.LoggerFactory
import java.net.URLEncoder
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/1
 * 微信: yin80871901
 */
class SignatureCreator(internal val appId: String, internal val secretKey: String) {

    private val logger = LoggerFactory.getLogger(SignatureCreator::class.java)

    /**
     * 生成随机数
     */
    fun genSalt() : Int {
        return (Random().nextDouble() * (10000 - 1000) + 1000).toInt()
    }

    /**
     * 生成令牌签名
     */
    fun genTokenSign(salt: Int) : String {
        val qs = sortedMapOf("app_id" to appId, "secret_key" to secretKey, "salt" to salt).map { "${it.key}=${it.value}" }.joinToString("&")
        if (logger.isDebugEnabled) logger.debug(".g1 - " + qs)
        val qsUrlencoded = URLEncoder.encode(qs, Charsets.UTF_8.name())
        if (logger.isDebugEnabled) logger.debug(".g2 - " + qsUrlencoded)
        return DigestUtils.md5Hex(qsUrlencoded)
    }

    /**
     * 生成请求令牌
     */
    fun genRequestSign(payload: String, accessToken: String, salt: Int) : String {

        // val payloadUrlencoded = URLUtils.getInstance().urlEncode(payload)

        val map = linkedMapOf(
                "app_id" to appId,
                "access_token" to accessToken,
                "data" to payload,
                "salt" to salt
        )

        // val gg1 = OpenSignHelper.generateBusinessSign(map)

        val qs = map.map { "${it.key}=${it.value}" }.joinToString("&")
        if (logger.isDebugEnabled) {
            // logger.debug("payloadUrlencoded: $payloadUrlencoded")
            logger.debug("qs: $qs")
        }

        // val gg2 = MD5Utils.getMD5Code(StringUtils.stripEnd(qs, "&"))
        return DigestUtils.md5Hex(StringUtils.stripEnd(qs, "&"))
    }

}
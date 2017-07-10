package cn.imdada

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import org.apache.commons.codec.digest.DigestUtils.md5Hex
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/3
 * 微信: yin80871901
 *
 * dock link: http://newopen.cn.imdada.cn/#/development/file/safety?_k=44nexh
 *
 * 签名算法
 * 签名生成的通用步骤如下：
 * 第一步：将参与签名的参数按照键值(key)进行字典排序
 * 第二步：将排序过后的参数，进行key和value字符串拼接
 * 第三步：将拼接后的字符串首尾加上app_secret秘钥，合成签名字符串
 * 第四步：对签名字符串进行MD5加密，生成32位的字符串
 * 第五步：将签名生成的32位字符串转换为大写
 */

/**
 *
 * @example:
 * {
 *   "body": "{\"order_id\":\"20170301000001\"}",
 *   "format": "json",
 *   "timestamp": "1488363493",
 *   "signature": "B3C14758F4AF52AE8AA0D4CD1493B137",
 *   "app_key": "app_key",
 *   "v": "1.0",
 *   "source_id": "73753"
 * }
 */
data class DDPayload(
        @get:JsonProperty("app_key") @SerializedName("app_key")
        val appKey: String,     // 应用Key，对应开发者账号中的app_key
        val signature: String,  // 签名Hash值，参见：接口签名规则
        val timestamp: String,  // 时间戳,单位秒，即unix-timestamp
        val format: String,     // 请求格式，暂时只支持json
        @get:JsonProperty("v") @SerializedName("v")
        val version: String,    // API版本
        @get:JsonProperty("source_id") @SerializedName("source_id")
        val sourceId: String,   // 商户编号（创建商户账号分配的编号）测试环境默认为：73753
        val body: String        // 业务参数，JSON字符串，详见具体的接口文档
)

fun signatureV1(body: String, appKey: String, appSecret: String, sourceId: String, timestamp: String) : String {
        val version = "1.0"
        val signSource = sortedMapOf(
                Pair("body", body),
                Pair("format", "json"),
                Pair("timestamp", timestamp),
                Pair("app_key", appKey),
                Pair("v", version),
                Pair("source_id", sourceId)
        ).toSortedMap(compareBy { key -> key})  // 通过 key 排序
        val joiner = StringJoiner("", appSecret, appSecret)
        signSource.forEach { _key, _val -> joiner.add("$_key$_val") }
        println(joiner.toString())
        return md5Hex(joiner.toString()).toUpperCase()
}

fun getPayload(body: String, appKey: String, appSecret: String, sourceId: String): DDPayload {
        val timestamp = Math.round((System.currentTimeMillis() / 1000).toDouble()).toString()
        val signature = signatureV1(body, appKey, appSecret, sourceId, timestamp)
        return DDPayload(appKey, signature, timestamp, "json", "1.0", sourceId, body)
}
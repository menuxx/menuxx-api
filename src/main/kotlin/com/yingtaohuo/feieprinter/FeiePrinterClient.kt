package com.yingtaohuo.feieprinter

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.KotlinModule
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import org.apache.commons.codec.digest.DigestUtils
import org.slf4j.LoggerFactory
import java.net.URLEncoder
import java.util.concurrent.TimeUnit

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/15
 * 微信: yin80871901
 */
enum class ApiName(val tyepName: String) {
    PrintMsg("Open_printMsg")
}

@JsonSerialize
data class PrintResponse(val msg: String, val ret: Int, val data: Any?, val serverExecutedTime: Int)

class FeiePrinterClient(val user: String, val ukey: String, val debug: Int?=0) {

    val logger = LoggerFactory.getLogger(FeiePrinterClient::class.java)!!

    val ApiUrl : String = "http://api.feieyun.cn/Api/Open/"

    val objectMapper: ObjectMapper = ObjectMapper()

    var httpClient: OkHttpClient

    init {

        objectMapper.registerModule(KotlinModule())

        httpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor { msg ->
                    logger.debug("FeiePrinter", msg)
                })
                .readTimeout(2, TimeUnit.SECONDS)
                .writeTimeout(2, TimeUnit.SECONDS)
                .build()

    }

    fun execCommand(targetSN: String, content: String, action: ApiName, debug: Int?=0) : String? {

        val stime = System.currentTimeMillis() / 1000
        val sig = DigestUtils.sha1Hex(user + ukey + stime)

        // url encode
        val _content = URLEncoder.encode(content, Charsets.UTF_8.name())
        val _user = URLEncoder.encode(user, Charsets.UTF_8.name())

        val body = "user=$_user&stime=$stime&sig=$sig&apiname=${action.tyepName}&debug=$debug&sn=$targetSN&content=$_content&times=1"

        if (logger.isDebugEnabled) {
            logger.debug("execCommand payload: $body")
            println("===========================")
            println("user: $user")
            println("stime: $stime")
            println("sig: $sig")
            println("apiname: ${action.tyepName}")
            println("sn: $targetSN")
            println("content: $content")
            println("===========================")
        }

        val reqBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), body)

        val request =  Request.Builder().url(ApiUrl).post(reqBody).build()

        val resp = httpClient.newCall(request).execute()

        if ( resp.isSuccessful ) {

            val respStr = resp.body()?.string()

            if (debug == 1) {
                logger.debug(resp.message() + "-" + respStr)
            }

            return respStr

        } else {

            logger.error(resp.message())

            return null

        }

    }

    fun print(targetSN: String, content: String, debug: Int?=0) : PrintResponse {
        val respStr = execCommand(targetSN, content, ApiName.PrintMsg, debug)
        return objectMapper.readValue(respStr, PrintResponse::class.java)
    }

}

package com.qq.weixin.wx3rd

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Feign
import feign.codec.Decoder
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/13
 * 微信: yin80871901
 */


class WXMessageClient {

    private val logger = LoggerFactory.getLogger(WXMessageClient::class.java)

    private val baseUrl = "https://api.weixin.qq.com/cgi-bin"

    fun build(objectMapper: ObjectMapper) : WXMessageApi {

        val okHttp = OkHttpClient.Builder()
                .addInterceptor( HttpLoggingInterceptor({ msg ->
                    logger.debug("WXMessage: $msg")
                    }).setLevel(HttpLoggingInterceptor.Level.BODY)
                )
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build()

        return Feign
                .builder()
                .decoder(JacksonDecoder(objectMapper))
                .encoder(JacksonEncoder(objectMapper))
                .client(feign.okhttp.OkHttpClient(okHttp))
                .target(WXMessageApi::class.java, baseUrl)
    }

}
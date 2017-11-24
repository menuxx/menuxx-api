package com.yingtaohuo.configure

import cn.imdada.ImDadaApi
import cn.imdada.ImDadaClientBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import com.yingtaohuo.props.DeliveryPlatformProperties
import me.ele.delivery.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/7
 * 微信: yin80871901
 * min 2000
 * nofee 5000
 * pack_fee 100
 * delivery_fee
 */
@Configuration
open class DeliveryPlatformConfigure (
        private val deliveryProps: DeliveryPlatformProperties,
        private val jsonMapper: ObjectMapper
) {

    private val logger = LoggerFactory.getLogger(DeliveryPlatformConfigure::class.java)!!

    fun getDefaultHttpClient() : OkHttpClient {

        val logging = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { msg -> println(msg) })
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .writeTimeout(3, TimeUnit.SECONDS)
                .addInterceptor((logging))
                .connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS)
                .build()
    }

    @Bean
    open fun imDadaApi() : ImDadaApi {
        val okHttp = getDefaultHttpClient()
        return ImDadaClientBuilder(deliveryProps.imdada!!.appKey, deliveryProps.imdada!!.appSecret)
                .jsonMapper(jsonMapper)
                .okHttp(okHttp)
                .enableProd(true)
                .build()
    }

    @Bean
    open fun eleApi() : EleApis {
        val appId = deliveryProps.ele!!.appId
        val secretKey = deliveryProps.ele!!.secretKey
        val okHttp = getDefaultHttpClient()
        val tokenClient = CachedAccessTokenClient(appId, secretKey, ProductionMode, jsonMapper)
        return EleApiClient(appId, secretKey, ProductionMode, tokenClient, jsonMapper, okHttp).buildApi()
    }

}
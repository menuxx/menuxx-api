package com.yingtaohuo.configure

import cn.imdada.ImDadaApi
import cn.imdada.ImDadaClientBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import com.yingtaohuo.props.ImDadaProperties
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
 */
@Configuration
open class ImDadaConfigure (
        val imdadaProps: ImDadaProperties,
        val jsonMapper: ObjectMapper
) {

    val logger = LoggerFactory.getLogger(ImDadaConfigure::class.java)!!

    fun getDefaultHttpClient() : OkHttpClient {

        val logging = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { msg -> logger.debug("ImDadaApi", msg) })
        logging.level = HttpLoggingInterceptor.Level.BASIC

        return OkHttpClient.Builder()
                .addInterceptor((logging))
                .connectTimeout(300, TimeUnit.MILLISECONDS)
                .readTimeout(500, TimeUnit.MILLISECONDS)
                .build()
    }

    @Bean
    open fun imDadaApi() : ImDadaApi {
        val okHttp = getDefaultHttpClient()
        return ImDadaClientBuilder(imdadaProps.appKey, imdadaProps.appSecret)
                .jsonMapper(jsonMapper)
                .okHttp(okHttp)
                .enableProd(true)
                .build()
    }

}
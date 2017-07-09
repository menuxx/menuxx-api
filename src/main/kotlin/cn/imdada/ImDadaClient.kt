package cn.imdada

import com.fasterxml.jackson.databind.ObjectMapper
import feign.*
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import okhttp3.OkHttpClient
import java.lang.reflect.Type

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/1
 * 微信: yin80871901
 */
class ImDadaClientBuilder (val appKey: String, val appSecret: String) {

    val protocol: String = "http://"
    /**
     * 设置是否是 工作在生产环境
     */
    private var workOnProd: Boolean = true
    private var loggerLevel: Logger.Level = Logger.Level.BASIC
    lateinit private var okHttp: OkHttpClient
    lateinit private var jsonMapper: ObjectMapper
    private var builder: Feign.Builder = Feign.builder()

    fun okHttp(okHttp: OkHttpClient) : ImDadaClientBuilder {
        this.okHttp = okHttp
        return this
    }

    fun logLevel(level: Logger.Level) : ImDadaClientBuilder {
        this.loggerLevel = level
        return this
    }


    fun jsonMapper(mapper: ObjectMapper): ImDadaClientBuilder {
        this.jsonMapper = mapper
        return this
    }

    /**
     * 设置是否是
     */
    fun enableProd(modeProd: Boolean = true) : ImDadaClientBuilder {
        workOnProd = modeProd
        return this
    }

    fun <T> buildApi(clazz: Class<T>, isProd: Boolean? = workOnProd): T {

        // 此处更新
        workOnProd = isProd ?: workOnProd

        builder.logLevel(loggerLevel)

        // 达达签名认证处理器
        builder.requestInterceptor(DDAuthInterceptor(jsonMapper, appKey, appSecret))

        if (jsonMapper != null) {
            val decoder = JacksonDecoder(jsonMapper)
            builder.decoder(decoder)
            builder.encoder(JacksonEncoder(jsonMapper))
            builder.mapAndDecode(RPM(jsonMapper), decoder)
        }

        if (okHttp != null) {
            builder.client(feign.okhttp.OkHttpClient(okHttp))
        }

        val baseUrl = protocol + if (workOnProd) API_HOST_PROD else API_HOST_TEST

        // 初始化客户端
        return builder.target(clazz, baseUrl)

    }

    /**
     * 构建客户端
     */
    fun build() : ImDadaApi {
        return buildApi(ImDadaApi::class.java)
    }

    /**
     * 构建模拟 api
     */
    fun buildMock() : MockImDadaApi {
        return buildApi(MockImDadaApi::class.java, isProd = false)
    }

}

class DDAuthInterceptor(val jsonMapper: ObjectMapper, val appKey: String, val appSecret: String) : RequestInterceptor {

    override fun apply(input: RequestTemplate) {
        val sourceId = input.queries()["source_id"]?.first() ?: ""
        val body = String(input.body() ?: "".toByteArray())
        val payload = getPayload(body, appKey, appSecret, sourceId)
        val json = jsonMapper.writeValueAsString(payload)
        println("payload json: $json")
        input.body(json)
    }

}

class RPM (val jsonMapper: ObjectMapper) : ResponseMapper {
    override fun map(response: Response, type: Type): Response {
        val ddResult = jsonMapper.readValue(response.body().asReader(), DDResult::class.java)
        // error
        if ( ddResult.code != 0 ) {
            throw ImDadaException(ddResult.status, ddResult.code, ddResult.msg)
        }
        return response.toBuilder().body(jsonMapper.writeValueAsBytes(ddResult.result)).build()
    }
}
package me.ele.delivery

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.cache.CacheBuilder
import java.util.concurrent.TimeUnit
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache
import feign.*
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.slf4j.LoggerFactory
import java.lang.reflect.Type
import java.net.URLEncoder


/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/1
 * 微信: yin80871901
 */

/**
 * accessToken 获取 token
 */

val urlTest = "https://exam-anubis.ele.me/anubis-webapi" // 联调接口
val urlProd = "https://open-anubis.ele.me/anubis-webapi"   // 生产接口

val ProductionMode = 1
val DevelopmentMode = 0

open class AccessTokenClient(private val appId: String, secretKey: String, mode: Int, jsonMapper: ObjectMapper?) {

    private val logger = LoggerFactory.getLogger(AccessTokenClient::class.java)

    private var apiClient : TokenApi

    private var signCreator: SignatureCreator

    private var objMapper: ObjectMapper = jsonMapper ?: ObjectMapper()

    init {

        val okHttp = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor { msg -> logger.debug(msg) })
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(4, TimeUnit.SECONDS)
                .build()

        val apiUrl = if (mode == 0) urlTest else urlProd

        if ( logger.isDebugEnabled ) {
            logger.debug("apply baseUrl $apiUrl")
        }

        apiClient = Feign
                .builder()
                .client(feign.okhttp.OkHttpClient(okHttp))
                .decoder(JacksonDecoder(objMapper))
                .encoder(JacksonEncoder(objMapper))
                .target(TokenApi::class.java, apiUrl)

        signCreator = SignatureCreator(appId, secretKey)
    }

    @Throws(FeignException::class)
    open fun getToken() : AccessToken {
        val salt = signCreator.genSalt()
        val sign = signCreator.genTokenSign(salt)
        logger.debug("salt: $salt, sign: $sign")
        val token = apiClient.getAccessToken(appId, salt, sign)
        if (logger.isDebugEnabled) {
            logger.debug("token: $token")
        }
        return token.data
    }
}

/**
 * 自带缓存功能的 AccessToken
 */
class CachedAccessTokenClient(appId: String, secretKey: String, mode: Int, jsonMapper: ObjectMapper?) : AccessTokenClient(appId, secretKey, mode, jsonMapper) {

    private val TokenCacheKey = "ele_access_token"

    private val cache : LoadingCache<String, AccessToken>

    init {
        cache = CacheBuilder.newBuilder().concurrencyLevel(4)
                .weakKeys()
                .maximumSize(10000)
                .softValues()
                .refreshAfterWrite(23, TimeUnit.HOURS)
                .expireAfterWrite(23, TimeUnit.HOURS)
                .build(object : CacheLoader<String, AccessToken>() {
                    @Throws(FeignException::class)
                    override fun load(key: String): AccessToken {
                        return getTokenFromEle()
                    }
                })
    }

    private fun getTokenFromEle() = super.getToken()

    override fun getToken() : AccessToken {
        return cache.get(TokenCacheKey)
    }

}

/**
 * 蜂鸟业务客户端
 */
open class EleApiClient(appId: String, secretKey: String, mode: Int, private val tokenClient: CachedAccessTokenClient, jsonMapper: ObjectMapper?, okHttpClient: OkHttpClient?) {

    private val logger = LoggerFactory.getLogger(EleApiClient::class.java)

    private lateinit var apiClient : EleApis

    private var signCreator: SignatureCreator

    private var apiUrl: String

    private var okHttp: OkHttpClient

    private var objMapper: ObjectMapper = jsonMapper ?: ObjectMapper()

    init {

        okHttp = okHttpClient ?: OkHttpClient.Builder()
                .addInterceptor( HttpLoggingInterceptor { msg -> logger.debug("YTH " + msg) }.setLevel(HttpLoggingInterceptor.Level.BODY) )
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(4, TimeUnit.SECONDS)
                .build()

        apiUrl = if (mode == 0) urlTest else urlProd

        if ( logger.isDebugEnabled ) {
            logger.debug("apply baseUrl $apiUrl")
        }

        signCreator = SignatureCreator(appId, secretKey)

    }

    fun buildApi() : EleApis {
        val decoder = JacksonDecoder(objMapper)
        val encoder = JacksonEncoder(objMapper)
        apiClient = Feign
                .builder()
                .client(feign.okhttp.OkHttpClient(okHttp))
                .requestInterceptor(EleSignRequestInterceptor(signCreator, tokenClient, objMapper))
                .decoder(decoder)
                .mapAndDecode(EleRPM(objMapper), decoder)
                .encoder(encoder)
                .target(EleApis::class.java, apiUrl)
        return apiClient
    }

}

class EleRPM (private val objMapper: ObjectMapper) : ResponseMapper {
    override fun map(response: Response, type: Type): Response {
        val result = objMapper.readValue<EleResult>(response.body().asReader(), EleResult::class.java)
        // error
        if ( result.code != 200 ) {
            throw EleException(result.code, result.msg)
        }
        return response.toBuilder().body(objMapper.writeValueAsBytes(result.data)).build()
    }
}

class EleSignRequestInterceptor(
        private val signCreator: SignatureCreator,
        private val tokenClient: AccessTokenClient,
        private val objMapper: ObjectMapper
) : RequestInterceptor {

    private val logger = LoggerFactory.getLogger(EleSignRequestInterceptor::class.java)

    override fun apply(input: RequestTemplate?) {
        if ( input != null ) {
            val bDataJson = URLEncoder.encode(String(input.body()).replace("\\s*[\\r\\n]+".toRegex(), "").replace("\\s*".toRegex(), "").trim(), "UTF-8")
            val salt = signCreator.genSalt()
            // val salt = 2879
            val accessToken = tokenClient.getToken().accessToken
            // val accessToken = "5f64e3e8-3dc6-430f-b75a-a68b9cc5648b"
            val signature = signCreator.genRequestSign(bDataJson, accessToken, salt)
            // val signature =
            // 封装 认证 包
            val authPack = objMapper.writeValueAsString(EleAuthPack(appId = signCreator.appId, salt = salt, signature = signature))
            // 再封包, 采用这种方法，是为了减少 序列化 反序列化的次数，提升效率
            // { "app_id": "xxx" } => { "app_id": "xxx" + "data": "xxxx" + }
            val newBody = authPack.substring(0, authPack.length-1) + ",\"data\":\"$bDataJson\"}"
            if (logger.isDebugEnabled) {
                logger.debug("appId: ${signCreator.appId}, salt: $salt, signature: $signature")
                logger.debug("new auth body : $newBody, length: ${newBody.length}")
            }
            input.body(newBody)
            input.header("Content-Type", "application/json;charset=UTF-8")
        }
    }

}
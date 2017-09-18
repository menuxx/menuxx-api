package com.yingtaohuo.configure

import com.yingtaohuo.props.CommonRedisProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
open class CommonRedisConfig(private val commonRedisProp: CommonRedisProperties) {

    private fun createConnFactory() : JedisConnectionFactory {
        val factory = JedisConnectionFactory()
        factory.hostName = commonRedisProp.host
        factory.port = commonRedisProp.port
        factory.timeout = commonRedisProp.timeout
        factory.database = commonRedisProp.database
        factory.password = commonRedisProp.password
        factory.poolConfig.maxIdle = commonRedisProp.pool!!.maxIdle
        factory.poolConfig.minIdle = commonRedisProp.pool!!.minIdle
        factory.poolConfig.maxWaitMillis = (commonRedisProp.pool!!.maxWait).toLong()
        factory.usePool = true
        factory.afterPropertiesSet()
        return factory
    }

    @Bean("commonRedisTemplate")
    open fun objRedisTemplate(jackson2JsonRedisSerializer: Jackson2JsonRedisSerializer<Any>): RedisTemplate<String, Any> {
        val redisTemplate = RedisTemplate<String, Any>()
        redisTemplate.connectionFactory = createConnFactory()
        redisTemplate.defaultSerializer = jackson2JsonRedisSerializer
        val stringRedisSerializer = StringRedisSerializer()
        redisTemplate.keySerializer = stringRedisSerializer
        redisTemplate.hashKeySerializer = stringRedisSerializer
        return redisTemplate
    }

}
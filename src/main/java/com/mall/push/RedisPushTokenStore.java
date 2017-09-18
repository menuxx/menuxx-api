package com.mall.push;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.HashMap;
import java.util.Map;

import static com.mall.push.Util.pushDeviceKey;

public class RedisPushTokenStore implements IPushTokenStore {

    RedisTemplate<String, Object> objRedisTemplates;

    public RedisPushTokenStore(RedisTemplate<String, Object> template) {
        this.objRedisTemplates = template;
    }

    @Override
    public Map<String, String> getTokens(String pushKey) {
        return (Map<String, String>) objRedisTemplates.opsForValue().get(pushDeviceKey(pushKey));
    }

    // 不穿在就创建，存在就添加
    @Override
    public Map<String, String> putToken(String pushKey, String channel, String token) {
        Map<String, String> tokenGroup = getTokens(pushKey);
        if (tokenGroup != null) {
            tokenGroup.put(channel, token);
            objRedisTemplates.opsForValue().set(pushDeviceKey(pushKey), tokenGroup);
            return tokenGroup;
        } else {
            Map<String, String> newTokenPair = new HashMap<>();
            newTokenPair.put(channel, token);
            objRedisTemplates.opsForValue().set(pushDeviceKey(pushKey), newTokenPair);
            return newTokenPair;
        }
    }
}

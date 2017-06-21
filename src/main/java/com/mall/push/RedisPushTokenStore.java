package com.mall.push;

import org.springframework.data.redis.core.ValueOperations;

import java.util.HashMap;
import java.util.Map;

import static com.mall.push.Util.pushDeviceKey;

public class RedisPushTokenStore implements IPushTokenStore {

    ValueOperations<String, Object> objOpts;

    public RedisPushTokenStore(ValueOperations<String, Object> objOpts) {
        this.objOpts = objOpts;
    }

    @Override
    public Map<String, String> getTokens(String pushKey) {
        return (Map<String, String>) objOpts.get(pushDeviceKey(pushKey));
    }

    // 不穿在就创建，存在就添加
    @Override
    public Map<String, String> putToken(String pushKey, String channel, String token) {
        Map<String, String> tokenGroup = getTokens(pushKey);
        if (tokenGroup != null) {
            tokenGroup.put(channel, token);
            objOpts.set(pushDeviceKey(pushKey), tokenGroup);
            return tokenGroup;
        } else {
            Map<String, String> newTokenPair = new HashMap<>();
            newTokenPair.put(channel, token);
            objOpts.set(pushDeviceKey(pushKey), newTokenPair);
            return newTokenPair;
        }
    }
}

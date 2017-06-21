package com.mall.push;

import org.springframework.data.redis.core.ValueOperations;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.mall.push.Util.pushDeviceKey;

public class RedisPushTokenStore implements IPushTokenStore {

    ValueOperations<String, Object> objOpts;

    public RedisPushTokenStore(ValueOperations<String, Object> objOpts) {
        this.objOpts = objOpts;
    }

    @Override
    public Map<String, String> getTokens(String pushKey) {
        return (Map<String, String>) checkNotNull(objOpts.get(pushDeviceKey(pushKey)), "diner not login, push_devices is empty");
    }

    // 不穿在就创建，存在就添加
    @Override
    public Map<String, String> putToken(String pushKey, String channel, String token) {
        try {
            Map<String, String> tokenGroup = getTokens(pushKey);
            tokenGroup.put(channel, token);
            objOpts.set(pushDeviceKey(pushKey), tokenGroup);
            return tokenGroup;
        } catch (NullPointerException e) {
            // diner not exists
            Map<String, String> newTokenPair = new HashMap<>();
            newTokenPair.put(channel, token);
            objOpts.set(pushDeviceKey(pushKey), newTokenPair);
            return newTokenPair;
        }
    }
}

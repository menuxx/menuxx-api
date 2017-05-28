package com.mall.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WXComponentService {

    public static final String COMPONENT_VERIFY_TICKET = "component_verify_ticket";

    public static final String COMPONENT_ACCESS_TOKEN = "component_access_token";

    public static final String PRE_AUTH_CODE = "pre_auth_code";

    public Map<String, String> cache = new ConcurrentHashMap<>();

    public String getComponentVerifyTicket() {
        return cache.get(COMPONENT_VERIFY_TICKET);
    }

    public String getComponentAccessToken() {
        return cache.get(COMPONENT_ACCESS_TOKEN);
    }

    public String getPreAuthCode() {
        return cache.get(PRE_AUTH_CODE);
    }

    public void updateCache(Map<String, String> cacheData) {
        cache.putAll(cacheData);
    }

    public Map<String, String> getCache() {
        return cache;
    }

}

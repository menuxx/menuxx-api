package com.mall.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WXComponentService {

    public static final String COMPONENT_ACCESS_TOKEN = "component_access_token";

    public Map<String, String> cache = new ConcurrentHashMap<>();

    public String getAccessToken() {
        return cache.get(COMPONENT_ACCESS_TOKEN);
    }

    public void setAccessToken(String token) {
        cache.put(COMPONENT_ACCESS_TOKEN, token);
    }

    public void updateCache(Map<String, String> cacheData) {
        cache.putAll(cacheData);
    }

    public Map<String, String> getCache() {
        return cache;
    }

}

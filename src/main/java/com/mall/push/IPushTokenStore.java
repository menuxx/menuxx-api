package com.mall.push;


import java.util.Map;

public interface IPushTokenStore {

    // 获取用户的所有 推送令牌
    Map<String, String> getTokens(String pushKey);

    // 添加 令牌
    Map<String, String> putToken(String pushKey, String tokenName, String token);

}

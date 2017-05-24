package com.mall.weixin.component;

import com.mall.weixin.WXCodeSession;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WXComponentApiService {

    /**
     * https://api.weixin.qq.com/sns/component/jscode2session?appid=APPID&js_code=JSCODE&grant_type=authorization_code&component_appid=COMPONENT_APPID&component_access_token=ACCESS_TOKEN
     * appid	是	小程序的AppID
     * js_code	是	登录时获取的 code
     * grant_type	是	填 authorization_code
     * component_appid	是	第三方平台appid
     * component_access_token	是	第三方平台的component_access_token
     * @param authorizerAppid 第三方授权 appId
     * @param jsCode
     * @param grantType
     * @param componentAppid
     * @param componentAccessToken
     * @return
     *
     * 返回说明（正常时返回的json示例）：
     * {
     *  "openid":“OPENID”,
     *  "session_key":"SESSIONKEY"
     * }
     * 返回参数说明：
     * 参数	说明
     * openid 	用户唯一标识的openid
     * session_key	会话密钥
     */
    @GET("component/jscode2session")
    Call<WXCodeSession> jscodeToSession(@Query("appid") String authorizerAppid, @Query("js_code") String jsCode, @Query("grant_type") String grantType, @Query("component_appid") String componentAppid, @Query("component_access_token") String componentAccessToken);

}

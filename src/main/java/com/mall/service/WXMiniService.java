package com.mall.service;

import com.mall.weixin.WXCodeSession;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 * 微信小程序api
 */
public interface WXMiniService {

	@GET("jscode2session")
	Call<WXCodeSession> jscodeToSession(@Query("appid") String appId, @Query("secret") String secret, @Query("js_code") String jsCode, @Query("grant_type") String grantType);

}

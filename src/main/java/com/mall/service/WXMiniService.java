package com.mall.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mall.exception.WXErrorMsg;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
public interface WXMiniService {

	@JsonIgnoreProperties(ignoreUnknown = true)
	class CodeSession extends WXErrorMsg {

		private String openid;

		private String sessionKey;

		public String getOpenid() {
			return openid;
		}

		public void setOpenid(String openid) {
			this.openid = openid;
		}

		public String getSessionKey() {
			return sessionKey;
		}

		public void setSessionKey(String sessionKey) {
			this.sessionKey = sessionKey;
		}
	}

	@GET("jscode2session")
	Call<CodeSession> jscodeToSession(@Query("appid") String appId, @Query("secret") String secret, @Query("js_code") String jsCode, @Query("grant_type") String grantType);

}

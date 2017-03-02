package com.mall.annotation;

import com.mall.utils.AESCoder;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
public class SessionData {

	private String appId;

	private String sessionKey;

	private int userId;

	private String mchid;

	public SessionData() {
	}

	public SessionData(String appId, String sessionKey, int userId, String mchid) {
		this.appId = appId;
		this.sessionKey = sessionKey;
		this.userId = userId;
		this.mchid = mchid;
	}

	public static SessionData create(String sessionToken) {
		sessionToken = AESCoder.decrypt(sessionToken);

		if ( !sessionToken.contains(":") ) {
			throw new IllegalArgumentException("pattern match of (.*):(.*)");
		}

		String[] strs = sessionToken.split(":");
		return new SessionData(strs[0], strs[1], Integer.valueOf(strs[2]), strs[3]);
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getMchid() {
		return mchid;
	}
}

package com.mall.annotation;

import com.mall.utils.AESCoder;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
public class SessionData {

	private String sessionKey;

	private int userId;

	private String mchid;

	private String openid;

	public SessionData() {
	}

	public SessionData(String openid, String sessionKey, int userId, String mchid) {
		this.sessionKey = sessionKey;
		this.userId = userId;
		this.mchid = mchid;
		this.openid = openid;
	}

	public static SessionData create(String sessionToken) {
		sessionToken = AESCoder.decrypt(sessionToken);

		if ( !sessionToken.contains(":") ) {
			throw new IllegalArgumentException("pattern match of (.*):(.*)");
		}

		String[] strs = sessionToken.split(":");
		return new SessionData(strs[0], strs[1], Integer.valueOf(strs[2]), strs[3]);
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

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getOpenid() {
		return openid;
	}
}

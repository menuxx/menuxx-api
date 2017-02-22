package com.mall.annotation;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
public class WXSessionData {

	private String appId;

	private String sessionKey;

	public WXSessionData() {
	}

	public WXSessionData(String appId, String sessionKey) {
		this.appId = appId;
		this.sessionKey = sessionKey;
	}

	public static WXSessionData create(String str) {
		if ( !str.contains(":") ) {
			throw new IllegalArgumentException("pattern match of (.*):(.*)");
		}
		String[] strs = str.split(":");
		return new WXSessionData(strs[0], strs[1]);
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
}

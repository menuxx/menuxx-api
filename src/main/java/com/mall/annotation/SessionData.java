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

	private Integer corpId;

	private String openid;

	private String sessionToken;

	public SessionData() {
	}

	public SessionData(String openid, String sessionKey, int userId, String mchid, Integer corpId) {
		this.sessionKey = sessionKey;
		this.userId = userId;
		this.mchid = mchid;
		this.openid = openid;
		this.corpId = corpId;
	}

	public static SessionData create(String sessionToken) {
		sessionToken = AESCoder.decrypt(sessionToken);

		if ( !sessionToken.contains(":") ) {
			throw new IllegalArgumentException("pattern match of (.*):(.*)");
		}

		String[] strs = sessionToken.split(":");

		if (strs.length == 5) {
			return new SessionData(strs[0], strs[1], Integer.valueOf(strs[2]), strs[3], Integer.valueOf(strs[4]));
		}

		return new SessionData(strs[0], strs[1], Integer.valueOf(strs[2]), strs[3], null);
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public Integer getCorpId() {
		return corpId;
	}

	public void setCorpId(Integer corpId) {
		this.corpId = corpId;
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

	public String getSessionToken() {
		//用户端 生成 token: 生成规则 aes(openid:session_key:userId:mchid)
		//客户端 生成 token: 生成规则 aes("":"":userId:corpId)
		String encrptyStr = this.getOpenid() + ":" + this.getSessionKey() + ":" + userId + ":" + this.getMchid();
		if ( this.getCorpId() != null ) {
			encrptyStr += ":" + this.getCorpId();
		}
		sessionToken = AESCoder.encrypt(encrptyStr);
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}
}

package com.mall.weixin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import com.mall.utils.Util;
import com.mall.weixin.encrypt.SignEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/3/2
 * 微信: yin80871901
 */
public class WXPaymentSignature {

	static final Logger logger = LoggerFactory.getLogger(WXPaymentSignature.class);

	private static final ObjectMapper mapper = new ObjectMapper();

	private String appId;

	private String timeStamp;

	@JsonProperty("packages")
	private String packages;

	private String paySign;

	private String signType = "MD5";

	private String nonceStr;

	@JsonIgnore
	private String appSecret;

	public WXPaymentSignature(String appId, String appSecret) {
		this.appId = appId;
		this.appSecret = appSecret;
	}

	public WXPaymentSignature update(String prePayId) {
		this.timeStamp = String.valueOf(Math.round(System.currentTimeMillis() / 1000));
		this.nonceStr = Util.genNonce();
		this.packages = "prepay_id=" + prePayId;
		return this;
	}

	public WXPaymentSignature digest(SignEncryptor encryptor) {
		signType = encryptor.type();
		try {
			String json = mapper.writeValueAsString(this);
			// WXPayOrder 转换成 querystring
			TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {};
			HashMap<String, String> props = mapper.readValue(json, typeRef);
			// 第一次不参与签名
			props.remove("paySign");
			// 1. key 排序
			Map<String, String> sortedProps = new TreeMap<>(props);
			// 2. 序列化成 querystring
			String qsVal = Joiner.on("&").withKeyValueSeparator("=").join(sortedProps);
			// 5. 拼接appSecret
			qsVal += ("&key=" + appSecret);
			// digest qsVal and upperCase
			this.paySign = encryptor.digest(qsVal).toUpperCase();
		} catch (IOException e) {
			logger.error("weixin payment signature fail! object to json exception");
			e.printStackTrace();
		}
		return this;
	}

	public Map<String, String> toMap() {
		try {
			String json = mapper.writeValueAsString(this);
			// WXPayOrder 转换成 querystring
			TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {};
			return mapper.readValue(json, typeRef);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
}

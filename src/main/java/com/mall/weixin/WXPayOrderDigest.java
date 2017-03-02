package com.mall.weixin;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.mall.weixin.encrypt.SignEncryptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/3/1
 * 微信: yin80871901
 */
public class WXPayOrderDigest {

	private WXPayOrder payOrder;

	private String appSecret;

	private static final ObjectMapper mapper = new ObjectMapper();

	public WXPayOrderDigest(WXPayOrder payOrder, String appSecret) {
		this.payOrder = payOrder;
		this.appSecret = appSecret;
	}

	public void digest(SignEncryptor encryptor) {
		payOrder.setSignType(encryptor.type());
		try {
			String json = mapper.writeValueAsString(payOrder);
			// com.dianfeng.weixinpaytest.WXPayOrder 转换成 querystring
			TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {};
			HashMap<String, String> props = mapper.readValue(json, typeRef);
			// 0. 去除空值
			Map<String, String> nonNullProps = Maps.filterEntries(props, (p)->p.getValue() != null);
			// 1. key 排序
			Map<String, String> sortedProps = new TreeMap<>(nonNullProps);
			// 2. 序列化成 querystring
			String qsVal = Joiner.on("&").withKeyValueSeparator("=").join(sortedProps);
			// 5. 拼接appSecret
			qsVal += ("&key=" + appSecret);
			// digest qsVal and upperCase
			String sign = encryptor.digest(qsVal).toUpperCase();
			payOrder.setSign(sign);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

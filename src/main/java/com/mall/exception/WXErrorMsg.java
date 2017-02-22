package com.mall.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
public class WXErrorMsg {

	private Integer errcode;

	private String errmsg;

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("errcode", errcode);
		map.put("errmsg", errmsg);
		return map;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}

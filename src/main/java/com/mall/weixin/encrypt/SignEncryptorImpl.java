package com.mall.weixin.encrypt;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/3/2
 * 微信: yin80871901
 */
public class SignEncryptorImpl {

	public static SignEncryptor HMAC_SHA256(String encryptKey) {
		return new SignEncryptor() {
			@Override
			public String type() {
				return "HMAC_SHA256";
			}

			@Override
			public String digest(String text) {
				return HmacUtils.hmacSha256Hex(encryptKey.getBytes(), text.getBytes());
			}
		};
	}

	public static SignEncryptor MD5() {
		return new SignEncryptor() {
			@Override
			public String type() {
				return "MD5";
			}

			@Override
			public String digest(String text) {
				return DigestUtils.md5Hex(text);
			}
		};
	}

}

package com.mall.utils;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESCoder {

	// 16位加密KEY
	private static final String KEY = "Gha0CsK57ReeMzt8";

	/**
	 * 解密
	 * @param sSrc
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String sSrc) {
		try {
			byte[] raw = KEY.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] encrypted1 = hex2byte(sSrc);
			byte[] original = cipher.doFinal(encrypted1);
			return new String(original);
		} catch (Exception ex) {
			throw new RuntimeException("AESCoder.decrypt fail:" + sSrc);
		}
	}

	/**
	 * 加密
	 *
	 * @param sSrc
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String sSrc) {
		try {
			byte[] raw = KEY.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(sSrc.getBytes());
			return byte2hex(encrypted).toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("AESCoder.decrypt encrypt");
		}
	}

	public static byte[] hex2byte(String strhex) {
		if (strhex == null) {
			return null;
		}
		int l = strhex.length();
		if (l % 2 == 1) {
			return null;
		}
		byte[] b = new byte[l / 2];
		for (int i = 0; i != l / 2; i++) {
			b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
		}
		return b;
	}

	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}
}
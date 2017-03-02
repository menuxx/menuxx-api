package com.mall.utils;

import java.util.List;
import java.util.Random;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
public class Util {

	public static  <T> T onlyOne(List<T> objs) {
		if ( objs == null ) {
			return null;
		}
		if (objs.size() < 1) {
			return null;
		}
		return objs.get(0);
	}

	public static String genNonce() {
		return genNonce(32);
	}

	public static String genNonce(int length) {
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(100000 + rnd.nextInt(900000));
		for (int i = 0; i < 20; i++)
			sb.append(chars[rnd.nextInt(chars.length)]);
		return sb.toString();
	}

}

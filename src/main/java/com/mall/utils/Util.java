package com.mall.utils;

import java.util.List;

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

}

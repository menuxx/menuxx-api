package com.mall.weixin.encrypt;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/3/2
 * 微信: yin80871901
 */
public interface SignEncryptor {
	String type();
	String digest(String text);
}

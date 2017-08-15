package com.mall.utils;

import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/15
 * 微信: yin80871901
 */
public class NumberUtil {

	public static String fenToYuanSymbol(int price) {
		return "￥" + fenToYuan(price);
	}

	public static String fenToYuan(double price) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		/*
		 * setMinimumFractionDigits设置成2
		 *
		 * 如果不这么做，那么当value的值是100.00的时候返回100
		 *
		 * 而不是100.00
		 */
		nf.setMinimumFractionDigits(2);
		nf.setRoundingMode(RoundingMode.HALF_UP);
		/*
		 * 如果想输出的格式用逗号隔开，可以设置成true
		 */
		nf.setGroupingUsed(false);
		return nf.format(price  / 100.00);
	}

	public static String fenToYuan2(int price) {
		return fenToYuan(price);
	}

}

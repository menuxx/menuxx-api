package com.mall.utils;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
public class Util {

	public static final DateFormat ORDER_NO_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINESE);

	/**
	 * 获取请求IP
	 * @param request
	 * @return
	 */
	public static String getRequestIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static String getYearMonthDay() {
		Date date = new Date();

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(date);
	}

	public static String dateFormat(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}


	public static String dateFormatNow() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(date);
	}

	public static String dateFormatAddMinites(int minites) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, minites);

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(calendar.getTime());
	}
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

	public static String generateCaptcha() {
		int random = RandomUtils.nextInt(0, 9999);
		String captcha = String.format("%04d", random);
		return captcha;
	}

	public static Map<String, Object> makeError(int errCode, String errMsg) {
		Map<String, Object> err = new HashMap<>();
		err.put("errCode", errCode);
		err.put("errMsg", errMsg);
		return err;
	}

	public static String genOrderNo() {
		return ORDER_NO_FORMAT.format(new Date()) + random(1, 99999);
	}

	public static int random(int min, int max) {
		return new Random().nextInt(max - min + 1) + min;
	}

}

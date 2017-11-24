package me.ele.delivery;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * urlencode工具类
 */
public class URLUtils {

	private static URLUtils instance = new URLUtils();
	private URLUtils(){}
	public static URLUtils getInstance(){
		return instance;
	}
	private String DEFAULT = "utf-8";
	
	public String urlEncode(String source) throws UnsupportedEncodingException{
		return urlEncode(source, DEFAULT);
	}
	public String urlEncode(String source, String type) throws UnsupportedEncodingException{
		return URLEncoder.encode(source, type);
	}
}

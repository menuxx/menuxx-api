package com.mall.interceptor;

import com.mall.model.TCorp;
import com.mall.service.CorpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.mall.annotation.CurrentDiner.CURRENT_DINER;
import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
@Component
public class CorpsInterceptor implements HandlerInterceptor {

	static final Pattern pathPattern = Pattern.compile("/diners/([0-9]*)");

	@Autowired
	CorpsService corpsService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		String url = request.getRequestURI();
		if ( !url.startsWith("/diners/")) {
			// 不处理 url 不匹配的
			return true;
		}
		Matcher corpIdMatcher = pathPattern.matcher(url);
		try {
			corpIdMatcher.find();
			String corpId = corpIdMatcher.group(1);
			if ( isEmpty(corpId) ) {
				throw new IllegalArgumentException("url参数不正确");
			}
			TCorp currCorp = corpsService.findByCorpId(Integer.parseInt(corpId));
			request.setAttribute(CURRENT_DINER, currCorp);
		} catch (IllegalStateException e) {
			throw new IllegalArgumentException("url参数不正确");
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
	}

}

package com.mall.bind;

import com.mall.annotation.SessionKey;
import com.mall.annotation.SessionData;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
public class SessionKeyMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(SessionKey.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		String sessionToken = webRequest.getHeader("X-Session-Token");
		if ( sessionToken == null ) {
			sessionToken = webRequest.getParameter("sessionToken");
		}
		if ( sessionToken == null ) {
			sessionToken = webRequest.getParameter("session_token");
		}
		if ( sessionToken == null ) {
			sessionToken = webRequest.getParameter("session-token");
		}
		if ( sessionToken == null ) {
			return null;
		} else {
			return SessionData.create(sessionToken);
		}
	}

}

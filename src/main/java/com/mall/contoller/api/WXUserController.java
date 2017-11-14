package com.mall.contoller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.annotation.CurrentDiner;
import com.mall.annotation.SessionKey;
import com.mall.annotation.SessionData;
import com.mall.configure.properties.AppConfigureProperties;
import com.mall.model.TCorp;
import com.mall.model.TUser;
import com.mall.service.UserService;
import com.mall.service.WXComponentService;
import com.mall.service.WXMiniService;
import com.mall.weixin.WXCodeSession;
import com.mall.weixin.component.WXComponentApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
@RestController
public class WXUserController extends BaseCorpController {

	static final Logger logger = LoggerFactory.getLogger(WXUserController.class);

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	WXMiniService wxMiniService;

	@Autowired
	UserService userService;

	@Autowired
	WXComponentApiService wxComponentApiService;

	@Autowired
    AppConfigureProperties appConfig;

	@Autowired
	WXComponentService componentService;

	static class LoginCode {

		@NotNull
		private String code;

		@NotNull
		private TUser user;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public TUser getUser() {
			return user;
		}

		public void setUser(TUser user) {
			this.user = user;
		}
	}

	interface NoArgFunction<R> {
		R apply();
	}

	private Map<String, Object> wxLitelogin(LoginCode loginCode, TCorp corp, NoArgFunction<Call<WXCodeSession>> jscodeToSession) {
		try {
			Response<WXCodeSession> codeSessionResp = jscodeToSession.apply().execute();
			if (codeSessionResp.isSuccessful()) {
				// 如果微信正确返回 状态码正确
				WXCodeSession session = codeSessionResp.body();
				return wxSessionApply(session, loginCode.getUser(), corp).toMap();
			} else {
				// 将微信返回的结果，解析后返回
				String errorJsonStr = codeSessionResp.errorBody().string();
				logger.error("wxLiteLogin -> errorJsonStr", errorJsonStr);
				@SuppressWarnings("unchecked")
				Map<String, Object> map = (Map<String, Object>) objectMapper.readValue(errorJsonStr, HashMap.class);
				return map;
			}
		} catch (Exception e) {
			logger.error("wxLiteLogin -> jscodeToSession", e);
			Map<String, Object> map = new HashMap<>();
			map.put("error", e.getMessage());
			return map;
		}

	}

	/**
	 * 微信小程序登录
	 * @param loginCode
	 * @param corp
	 * @return
	 */
	@PutMapping("wx/liteLogin")
	public Map<String, Object> wxLiteLogin(@Valid @RequestBody LoginCode loginCode, @CurrentDiner final TCorp corp) {
		String grandType = "authorization_code";
		return wxLitelogin(loginCode, corp, () -> wxMiniService.jscodeToSession(corp.getAuthorizerAppid(), corp.getAppSecret(), loginCode.code, grandType));
	}

	@PutMapping("wx/liteComponentLogin")
	public Map<String, Object> wxLiteComponentLogin(@Valid @RequestBody LoginCode loginCode, @CurrentDiner final TCorp corp) {
		String grandType = "authorization_code";
		return wxLitelogin(loginCode, corp, () -> wxComponentApiService.jscodeToSession(corp.getAuthorizerAppid(), loginCode.code, grandType, appConfig.getWxComponent().getAppId(), componentService.getAccessToken()));
	}

	private SessionData wxSessionApply(WXCodeSession session, TUser user, TCorp corp) {
		if ( session.getErrcode() == null ) {
			// 根据 openid 和 corp 创建或修改用户
			user.setOpenid(session.getOpenid());
			int userId = userService.saveUser(user, corp);
			return new SessionData(session.getOpenid(), session.getSessionKey(), userId, corp.getMchId(), corp.getId());
		} else {
			throw new RuntimeException(session.getErrmsg());
		}
	}

	/**
	 * 用户录入, 幂等操作
	 * @param user
	 * @param corp
	 * @param sessionData
	 * @return
	 */
	@PutMapping("wx/liteSigin")
	public Map<String, Object> liteSigin(@Valid @RequestBody TUser user, @CurrentDiner TCorp corp, @SessionKey SessionData sessionData) {
		user.setCorpId(corp.getId());
		userService.saveUser(user, corp);
		Map<String, Object> data = new HashMap<>();
		data.put("userId", user.getId());
		data.put("openId", user.getOpenid());
		data.put("corpId", corp.getId());
		return data;
	}

}

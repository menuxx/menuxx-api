package com.mall.contoller.api;

import com.mall.annotation.CurrentDiner;
import com.mall.annotation.SessionKey;
import com.mall.annotation.SessionData;
import com.mall.configure.AppConfiguration;
import com.mall.model.TCorp;
import com.mall.model.TUser;
import com.mall.service.UserService;
import com.mall.service.WXMiniService;
import com.mall.weixin.WXCodeSession;
import com.mall.weixin.component.WXComponentApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import retrofit2.Call;
import retrofit2.Callback;
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
	WXMiniService wxMiniService;

	@Autowired
	UserService userService;

	@Autowired
	WXComponentApiService wxComponentApiService;

	@Autowired
	AppConfiguration appConfig;

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

	/**
	 * 微信小程序登录
	 * @param loginCode
	 * @param corp
	 * @return
	 */
	@PutMapping("wx/liteLogin")
	public DeferredResult<Object> wxLiteLogin(@Valid @RequestBody LoginCode loginCode, @CurrentDiner final TCorp corp) {
		final DeferredResult<Object> deferred = new DeferredResult<>();

		wxMiniService.jscodeToSession(corp.getAuthorizerAppId(), corp.getAppSecret(), loginCode.getCode(), "authorization_code").enqueue(new Callback<WXCodeSession>() {
			@Override
			public void onResponse(Call<WXCodeSession> call, Response<WXCodeSession> response) {
				WXCodeSession session = response.body();
				if ( session.getErrcode() == null ) {
					String openid = session.getOpenid();

					// 根据openid和corp 创建或修改用户
					TUser user = loginCode.getUser();
					user.setOpenid(openid);

					int userId = userService.saveUser(user, corp);

					SessionData sessionData = new SessionData(session.getOpenid(), session.getSessionKey(), userId, corp.getMchId());
					deferred.setResult(sessionData);
				} else {
					deferred.setErrorResult(session);
				}
			}
			@Override
			public void onFailure(Call<WXCodeSession> call, Throwable throwable) {
				logger.error("wxLiteLogin -> jscodeToSession", throwable);
				deferred.setErrorResult(throwable);
			}
		});
		return deferred;
	}

	@PutMapping("wx/liteComponentLogin")
	public DeferredResult<Object> wxLiteComponentLogin(@Valid @RequestBody LoginCode loginCode, @CurrentDiner final TCorp corp) {
		final DeferredResult<Object> deferred = new DeferredResult<>();
		wxComponentApiService.jscodeToSession(
				corp.getAuthorizerAppId(),
				loginCode.getCode(),
				"authorization_code",
				appConfig.getWxComponent().getAppId(),
				"YktSoLfv-xd5PRp6hP5_dLnRuuUqPGXz7GT4w1lomkUqlw3gx5vp7_AoxhfDAeVozhFXzWPMefe-KVX5dueCBqoujr505Qxj_ciPHzQ9UkuYOADUJTymQCfA0TOebOjNNKDhAFABYR"
				).enqueue(new Callback<WXCodeSession>() {
			@Override
			public void onResponse(Call<WXCodeSession> call, Response<WXCodeSession> response) {
				WXCodeSession session = response.body();
				if ( session.getErrcode() == null ) {
					String openid = session.getOpenid();

					// 根据openid和corp 创建或修改用户
					TUser user = loginCode.getUser();
					user.setOpenid(openid);

					int userId = userService.saveUser(user, corp);

					SessionData sessionData = new SessionData(session.getOpenid(), session.getSessionKey(), userId, corp.getMchId());
					deferred.setResult(sessionData);
				} else {
					deferred.setErrorResult(session);
				}
			}
			@Override
			public void onFailure(Call<WXCodeSession> call, Throwable throwable) {
				logger.error("wxLiteLogin -> jscodeToSession", throwable);
				deferred.setErrorResult(throwable);
			}
		});
		return deferred;

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

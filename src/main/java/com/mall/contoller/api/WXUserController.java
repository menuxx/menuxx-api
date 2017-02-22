package com.mall.contoller.api;

import com.mall.annotation.CurrentDiner;
import com.mall.annotation.SessionKey;
import com.mall.annotation.WXSessionData;
import com.mall.model.TCorp;
import com.mall.model.TUser;
import com.mall.service.UserService;
import com.mall.service.WXMiniService;
import com.mall.utils.AESCoder;
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

	static class LoginCode {

		@NotNull
		private String code;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
	}

	/**
	 * 微信小程序登录
	 * @param loginCode
	 * @param corp
	 * @return
	 */
	@PutMapping("wx/liteLogin")
	public DeferredResult<Map<String, Object>> wxLiteLogin(@Valid @RequestBody LoginCode loginCode, @CurrentDiner final TCorp corp) {
		final DeferredResult<Map<String, Object>> deferred = new DeferredResult<>();
		wxMiniService.jscodeToSession(corp.getAppId(), corp.getAppSecret(), loginCode.getCode(), "authorization_code").enqueue(new Callback<WXMiniService.CodeSession>() {
			@Override
			public void onResponse(Call<WXMiniService.CodeSession> call, Response<WXMiniService.CodeSession> response) {
				WXMiniService.CodeSession session = response.body();
				Map<String, Object> data = new HashMap<>();
				if ( session.getErrcode() == null ) {
					// 产生 token
					// token 生成规则 aes(appid:session_key)
					String sessionToken = AESCoder.encrypt(session.getOpenid() + ":" + session.getSessionKey());
					data.put("sessionToken", sessionToken);
					data.put("openid", session.getOpenid());
					data.put("corpId", corp.getId());
					deferred.setResult(data);
				} else {
					deferred.setErrorResult(session);
				}
			}
			@Override
			public void onFailure(Call<WXMiniService.CodeSession> call, Throwable throwable) {
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
	public Map<String, Object> liteSigin(@Valid @RequestBody TUser user, @CurrentDiner TCorp corp, @SessionKey WXSessionData sessionData) {
		System.out.println(sessionData);
		userService.saveUser(user, corp);
		Map<String, Object> data = new HashMap<>();
		data.put("userId", user.getId());
		data.put("openId", user.getOpenid());
		data.put("corpsId", corp.getId());
		return data;
	}

}
package com.mall.push.pusher;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.push.model.v20160801.PushRequest;
import com.aliyuncs.push.model.v20160801.PushResponse;
import com.aliyuncs.utils.ParameterHelper;
import com.mall.push.AbstractPusher;
import com.mall.push.ClientInitException;
import com.mall.push.PushConst;
import com.mall.push.PushState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/6/22
 * 微信: yin80871901
 * 阿里推送
 * 支持 华为,小米推送通道
 * https://help.aliyun.com/document_detail/48048.html?spm=5176.doc30067.6.627.6L6hcy
 */
public class AliPusher extends AbstractPusher {

	static final Logger logger = LoggerFactory.getLogger(AliPusher.class);

	static final String PUSHER_NAME = "alibaba_push";

	private Long appKey;

	private String accessKeyId;

	private String accessKeySecret;

	private DefaultAcsClient acsClient;

	public AliPusher(String accessKeyId, String accessKeySecret, Long appkey) {
		this.accessKeyId = accessKeyId;
		this.accessKeySecret = accessKeySecret;
		this.appKey = appkey;
	}

	@Override
	public String getName() {
		return PUSHER_NAME;
	}

	@Override
	public void initialize() throws ClientInitException {
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		acsClient = new DefaultAcsClient(profile);
	}

	@Override
	public PushState pushToClient(String clientId, String payload, Map<String, Object> opts) {
		PushRequest pushRequest = new PushRequest();
		// 推送目标
		pushRequest.setAppKey(appKey);
		// 推送目标: DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送
		pushRequest.setTarget("ACCOUNT");
		//根据Target来设定，如Target=DEVICE, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
		// pushRequest.setTargetValue(pushToken);
		pushRequest.setTargetValue(clientId);
		// 消息类型 MESSAGE NOTICE
		pushRequest.setPushType("MESSAGE");
		// 设备类型 ANDROID iOS ALL.
		pushRequest.setDeviceType("ANDROID");
		// 推送配置
		pushRequest.setTitle(getOptStr(opts, PushConst.OPTS_MSG_EXTRA_TITLE)); // 消息的标题
		pushRequest.setBody(payload); // 消息的内容
		if ( getOptBool(opts, PushConst.OPTS_MSG_EXPIRE_ENABLE) ) {
			// 转换时间格式
			String expireTime = ParameterHelper.getISO8601Time(new Date(System.currentTimeMillis() + getOptLong(opts, PushConst.OPTS_MSG_EXPIRE_TIME)));
			pushRequest.setExpireTime(expireTime);
			// 离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到
			pushRequest.setStoreOffline(true);
		}
		try {
			PushResponse pushResponse = acsClient.getAcsResponse(pushRequest);
			logger.debug("RequestId: " + pushResponse.getRequestId() + ", MessageID: " + pushResponse.getMessageId());
			return new PushState(true, "ok", pushResponse.getMessageId());
		} catch (ClientException e) {
			logger.error("alipush pushing failed. ", e);
			return new PushState(false, e.getErrMsg());

		}
	}
}

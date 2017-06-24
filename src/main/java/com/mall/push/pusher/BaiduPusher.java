package com.mall.push.pusher;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;
import com.mall.push.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class BaiduPusher extends AbstractPusher {

    static final Logger logger = LoggerFactory.getLogger(BaiduPusher.class);

    public static final String PUSHER_NAME = "baidu-push";

    /**
     * 1. 创建PushKeyPair
     * 用于app的合法身份认证
     * apikey和secretKey可在应用详情中获取
     */
    PushKeyPair keyPair;

    BaiduPushClient pushClient;

    public BaiduPusher(String apiKey, String secretKey) {
        keyPair = new PushKeyPair(apiKey, secretKey);
        pushClient = initClient();
    }

    private BaiduPushClient initClient() {
        // 2. 创建BaiduPushClient，访问SDK接口
        return new BaiduPushClient(keyPair,
                BaiduPushConstants.CHANNEL_REST_URL);
    }

    @Override
    public String getName() {
        return PUSHER_NAME;
    }

    @Override
    public void initialize() throws ClientInitException {
        // 3. 注册YunLogHandler，获取本次请求的交互信息
        pushClient.setChannelLogHandler (event -> {
            switch (event.getLevel()) {
                case YunLogEvent.DEBUG:
                    logger.debug(event.getMessage());
                    break;
                case YunLogEvent.FATAL:
                    logger.error(event.getMessage());
                    break;
                case YunLogEvent.WARNING:
                    logger.warn(event.getMessage());
                    break;
                case YunLogEvent.NOTICE:
                    logger.error(event.getMessage());
                    break;
                case YunLogEvent.INFO:
                    logger.info(event.getMessage());
                    break;
            }
        });
    }

    /**
     * doc http://push.baidu.com/doc/java/api
     * @param clientChannelId
     * @param payload
     * @param opts
     * @return
     */
    @Override
    public PushState pushToClient(String clientChannelId, String payload, Map<String, Object> opts) {
        // 4. 设置请求参数，创建请求实例
        PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest()
                .addChannelId(clientChannelId)
                .addMessageType(0)      // 设置消息类型,0表示透传消息,1表示通知,默认为0.
                .addMessage(payload)
                .addDeviceType(3);   // 设置设备类型，deviceType => 1 for web, 2 for pc, 3 for android, 4 for ios, 5 for wp.

        if (getOptBool(opts, PushConst.OPTS_MSG_EXPIRE_ENABLE)) {
            request.setMsgExpires(Math.round(getOptLong(opts, PushConst.OPTS_MSG_EXPIRE_TIME) / 1000));
            // 设置消息的有效时间,单位秒,默认3600*5.
        }

        // 5. 执行Http请求
        try {
            PushMsgToSingleDeviceResponse response = pushClient.pushMsgToSingleDevice(request);
            // 6. Http请求返回值解析
            logger.debug("msgId: "+ response.getMsgId() +" ,sendTime: " + response.getSendTime());
            return new PushState(true, "ok", response.getMsgId());
        } catch (PushClientException e) {
            // ERROROPTTYPE 用于设置异常的处理方式 -- 抛出异常和捕获异常,
            //'true' 表示抛出, 'false' 表示捕获。
            if (BaiduPushConstants.ERROROPTTYPE) {
                throw new PushException("pushing failed. ", e);
            } else {
                logger.error("pushing failed. ", e);
                return new PushState(false, e.getMessage());
            }
        } catch (PushServerException e) {
            if (BaiduPushConstants.ERROROPTTYPE) {
                throw new PushException("pushing failed. ", e);
            } else {
                logger.error("requestId: %d, errorCode: %d, errorMsg: %s", e.getRequestId(), e.getErrorCode(), e.getErrorMsg());
                return new PushState(false, e.getErrorMsg());
            }
        }
    }

}

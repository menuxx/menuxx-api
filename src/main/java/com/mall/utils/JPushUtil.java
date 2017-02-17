package com.mall.utils;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Created by Supeng on 16/02/2017.
 */
public class JPushUtil {

    protected static final Logger LOG = LoggerFactory.getLogger(JPushUtil.class);

    protected static final String APP_KEY ="12897b3b2bd0f9b8fbffc06e";
    protected static final String MASTER_SECRET = "ed2cd6d652350b609adff171";

    private static JPushClient jpushClient = null;

    public static JPushClient getJPushClient() {
        if (null == jpushClient) {
            ClientConfig clientConfig = ClientConfig.getInstance();
            jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
        }

        return jpushClient;
    }

    public static void sendPushOrder(String content, String tag) {
        JPushClient jpushClient = getJPushClient();
        PushPayload pushPayload = buildPushPayLoad(content, tag);

        try {
            PushResult result = jpushClient.sendPush(pushPayload);
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);

        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        }
    }

    private static PushPayload buildPushPayLoad(String content, String tag) {
        return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.tag(tag)).setMessage(Message.content(content)).build();
    }

}

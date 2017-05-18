package com.mall.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.mall.configure.AppConfiguration;
import com.mall.model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Supeng on 10/03/2017.
 */
public class IPushUtil {

    //定义常量, appId、appKey、masterSecret 采用本文档 "第二步 获取访问凭证 "中获得的应用配置
//    private static String appId = "cbEnp7I9DO6I71axST5bKA";
//    private static String appKey = "gkHgaZzxJ2A5BASWIIK8Z2";
//    private static String masterSecret = "gK9wqQLNKm6bZe0JNYcAQ7";
//    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

    public static void sendPushOrder(AppConfiguration appConfiguration, ObjectMapper objectMapper, Order order, List<String> clientIdList) {
        try {
            String content = objectMapper.writeValueAsString(order);
            sendPushOrder(appConfiguration, content, clientIdList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void sendPushOrder(AppConfiguration appConfiguration, String content, List<String> clientIdList) {
        IGtPush push = new IGtPush(appConfiguration.getIpushUrl(), appConfiguration.getIpushAppKey(), appConfiguration.getIpushMasterSecret());

        // 透传模版
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(appConfiguration.getIpushAppId());
        template.setAppkey(appConfiguration.getIpushAppKey());
        template.setTransmissionType(Integer.parseInt(appConfiguration.getTransmissionType())); //收到消息是否立即启动应用，1为立即启动，2则广播等待客户端自启动
        template.setTransmissionContent(content); //content长度：2048中/英字符，不支持转义字符

        ListMessage message = new ListMessage();
        message.setOfflineExpireTime(10 * 3600 * 1000);
        message.setData(template);

        List<Target> targetList = new ArrayList<>();

        for (String clientId : clientIdList) {
            // 配置推送目标
            Target target = new Target();
            target.setAppId(appConfiguration.getIpushAppId());
            target.setClientId(clientId);

            targetList.add(target);
        }

        String taskId = push.getContentId(message);
        IPushResult result = push.pushMessageToList(taskId, targetList);
        System.out.println(result.getResponse().toString());
    }
}

package com.mall.scheduler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.configure.properties.AppConfigureProperties;
import com.mall.model.Order;
import com.mall.model.TCorpUser;
import com.mall.push.DinerPushManager;
import com.mall.service.CorpUserService;
import com.mall.wrapper.OrderWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Supeng on 23/05/2017.
 */
@Component
public class SelfCheckScheduler {

    @Autowired
    OrderWrapper orderWrapper;

    @Autowired
    CorpUserService corpUserService;

    @Autowired
    AppConfigureProperties appConfig;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    DinerPushManager pushManager;

    /**
     * 每日早上 9 点发出推送测试流程
     */
    @Scheduled(cron = "0 0 9 * * *")
    public void doSelfCheck() {
        System.out.println("************************ doSelfCheck scheduler start ***************************");
        System.out.println("************************ " + new Date() + " ***************************");

        Order order = orderWrapper.buildTestOrder(2);

        List<TCorpUser> userList = corpUserService.selectAllCorpUsers();

        List<String> clientIdList = new ArrayList<>();

        if (userList != null && userList.size() > 0) {
            for (TCorpUser corpUser : userList) {
                if (StringUtils.isNotBlank(corpUser.getClientId())) {
                    clientIdList.add(corpUser.getClientId());
                }
            }
        }

        orderWrapper.pushOrder(order, clientIdList);

        for (TCorpUser corpUser : userList) {
            pushManager.pushOrderToShopReceiver(corpUser.getPushKey(), order);
        }

        System.out.println("************************ doSelfCheck scheduler end *****************************");
    }
}

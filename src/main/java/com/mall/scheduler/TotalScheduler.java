package com.mall.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.configure.AppConfiguration;
import com.mall.model.Order;
import com.mall.model.TCorpUser;
import com.mall.service.CorpUserService;
import com.mall.service.StatisticsService;
import com.mall.utils.IPushUtil;
import com.mall.wrapper.OrderWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Supeng on 31/03/2017.
 */
@Component
public class TotalScheduler {

    @Autowired
    StatisticsService statisticsService;

    @Autowired
    OrderWrapper orderWrapper;

    @Autowired
    CorpUserService corpUserService;

    @Autowired
    AppConfiguration appConfiguration;

    @Autowired
    ObjectMapper objectMapper;

    /**
     * 每日凌晨 3 点统计数据
     */
    @Scheduled(cron = "0 0 3 * * *")
    public void doStatistics() {
        System.out.println("************************ doStatistics scheduler start ***************************");
        System.out.println("************************ " + new Date() + " ***************************");
        statisticsService.doStatistics();
        System.out.println("************************ doStatistics scheduler end *****************************");
    }

    /**
     * 每日早上 9 点发出推送测试流程
     */
    @Scheduled(cron = "0 0 17 * * *")
    public void doSelfCheck() {
        System.out.println("************************ doSelfCheck scheduler start ***************************");
        System.out.println("************************ " + new Date() + " ***************************");

        Order order = orderWrapper.buildTestOrder();

        List<TCorpUser> userList = corpUserService.selectAllCorpUsers();

        List<String> clientIdList = new ArrayList<>();

//        if (userList != null && userList.size() > 0) {
//            for (TCorpUser corpUser : userList) {
//                if (StringUtils.isNotBlank(corpUser.getClientId())) {
//                    clientIdList.add(corpUser.getClientId());
//                }
//            }
//        }

        clientIdList.add("195d25e14fc157ebd65ed447a5c86911");

        IPushUtil.sendPushOrder(appConfiguration, objectMapper, order, clientIdList);

        System.out.println("************************ doSelfCheck scheduler end *****************************");
    }


}

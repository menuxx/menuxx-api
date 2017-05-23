package com.mall.scheduler;

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
     * 每日凌晨 2 点统计数据
     */
    @Scheduled(cron = "0 0 2 * * *")
    public void doStatistics() {
        System.out.println("************************ doStatistics scheduler start ***************************");
        System.out.println("************************ " + new Date() + " ***************************");
        statisticsService.doStatistics();
        System.out.println("************************ doStatistics scheduler end *****************************");
    }

}

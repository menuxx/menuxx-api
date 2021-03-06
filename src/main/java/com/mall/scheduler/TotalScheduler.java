package com.mall.scheduler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.configure.properties.AppConfigureProperties;
import com.mall.service.CorpUserService;
import com.mall.service.StatisticsService;
import com.mall.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

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
    AppConfigureProperties appConfig;

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

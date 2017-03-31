package com.mall.scheduler;

import com.mall.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Supeng on 31/03/2017.
 */
@Component
public class TotalScheduler {

    @Autowired
    StatisticsService statisticsService;

    /**
     * 每日凌晨 3 点统计数据
     */
    @Scheduled(cron = "0 0 3 * * *")
    public void doStatistics() {
        statisticsService.doStatistics();
    }
}

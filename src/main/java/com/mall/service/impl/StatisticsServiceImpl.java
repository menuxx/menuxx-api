package com.mall.service.impl;

import com.mall.mapper.StatisticsMapper;
import com.mall.model.TCorp;
import com.mall.model.TCorpTotal;
import com.mall.service.CorpService;
import com.mall.service.CorpTotalService;
import com.mall.service.StatisticsService;
import com.mall.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Supeng on 31/03/2017.
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    StatisticsMapper statisticsMapper;

    @Autowired
    CorpTotalService corpTotalService;

    @Autowired
    CorpService corpService;

    @Override
    public List<TCorpTotal> selectByDay(Map<String, String> dayMap) {
        return statisticsMapper.selectByDay(dayMap);
    }

    @Override
    public List<TCorpTotal> selectByToday() {
        Map<String, String> dayMap = getTodayMap();
        return selectByDay(dayMap);
    }

    private Map<String, String> getTodayMap() {
        Map<String, String> dayMap = new HashMap<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        String toDay = dateFormat.format(calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        String fromDay = dateFormat.format(calendar.getTime());

        dayMap.put("toDay", toDay);
        dayMap.put("fromDay", fromDay);
        return dayMap;
    }

    @Override
    public void doStatistics() {
        Map<String, String> todayMap = new HashMap<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        String toDay = dateFormat.format(calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        String fromDay = dateFormat.format(calendar.getTime());

        Date yesterday = calendar.getTime();

        todayMap.put("toDay", toDay);
        todayMap.put("fromDay", fromDay);

        // 获取所有的商家
        List<TCorp> corpList = corpService.selectAllCorps();

        // 获取统计信息
        Map<Integer, TCorpTotal> totalMap = selectTotal(todayMap, yesterday);

       for (TCorp corp : corpList) {
           if (totalMap.containsKey(corp.getId())) {
               corpTotalService.createCorpTotal(totalMap.get(corp.getId()));
           } else {
               TCorpTotal corpTotal = new TCorpTotal();
               corpTotal.setDay(yesterday);
               corpTotal.setCorpId(corp.getId());
               corpTotal.setIncomeTotal(0);
               corpTotal.setOrderTotal(0);
               corpTotal.setArerage(0);
               corpTotalService.createCorpTotal(corpTotal);
           }
       }



    }

    private Map<Integer, TCorpTotal> selectTotal(Map<String, String> dayMap, Date yesterday) {
        Map<Integer, TCorpTotal> map = new HashMap<>();

        List<TCorpTotal> totalList = selectByDay(dayMap);

        if (totalList.size() > 0) {
            for (TCorpTotal total : totalList) {
                TCorpTotal existed = corpTotalService.selectCorpTotal(total.getCorpId(), yesterday);

                if (existed == null) {
                    TCorpTotal corpTotal = new TCorpTotal();
                    corpTotal.setDay(yesterday);
                    corpTotal.setCorpId(total.getCorpId());
                    corpTotal.setIncomeTotal(total.getIncomeTotal());
                    corpTotal.setOrderTotal(total.getOrderTotal());
                    corpTotal.setArerage(total.getIncomeTotal() / total.getOrderTotal());

                    map.put(total.getCorpId(), corpTotal);
                }
            }
        }

        return map;
    }
}

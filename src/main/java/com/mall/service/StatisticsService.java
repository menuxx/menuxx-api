package com.mall.service;

import com.mall.model.TCorpTotal;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 31/03/2017.
 */
public interface StatisticsService {

    List<TCorpTotal> selectByDay(Map<String, String> dayMap);

    TCorpTotal selectByToday(int corpId);

    void doStatistics();
}

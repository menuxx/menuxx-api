package com.mall.mapper;

import com.mall.model.TCorpTotal;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 31/03/2017.
 */
public interface StatisticsMapper {

    List<TCorpTotal> selectByDay(Map<String, String> dayMap);

}

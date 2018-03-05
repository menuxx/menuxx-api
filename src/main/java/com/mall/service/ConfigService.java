package com.mall.service;

import com.mall.mapper.TConfigMapper;
import com.mall.mapper.TCorpMapper;
import com.mall.mapper.TShopBusinessTimeMapper;
import com.mall.mapper.TShopConfigMapper;
import com.mall.model.*;
import com.mall.utils.Util;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ConfigService {

    @Autowired
    TConfigMapper tConfigMapper;

    @Autowired
    TShopConfigMapper tShopConfigMapper;

    @Autowired
    TCorpMapper tCorpMapper;

    @Autowired
    TShopBusinessTimeMapper tShopBusinessTimeMapper;

    public Integer saveBusinessTimeline(Integer corpId, String timeline) {
        TShopConfig config = selectConfig(corpId);
        config.setBusinessTimeline(timeline);
        return tShopConfigMapper.updateByPrimaryKey(config);
    }

    public TShopConfig selectConfig(Integer shopId) {
        TShopConfigExample ex = new TShopConfigExample();
        ex.createCriteria().andShopIdEqualTo(shopId);
        return Util.onlyOne(tShopConfigMapper.selectByExample(ex));
    }

    public List<TConfig> selectMyConfigs(Integer corpId) {
        TConfigExample ex = new TConfigExample();
        ex.createCriteria().andCorpIdEqualTo(corpId);
        return tConfigMapper.selectByExample(ex);
    }

    public Map<String, Object> selectMyConfigs4Map(Integer corpId) {
        List<TConfig> list = selectMyConfigs(corpId);

        Map<String, Object> map = new HashMap<>();

        for (TConfig config : list) {
            map.put(config.getName(), config.getValue());
        }

        return map;
    }


    public void updateShopInWork(int shopId , int inWork) {
        TShopConfig config = new TShopConfig();
        config.setInWork(inWork);
        TShopConfigExample ex = new TShopConfigExample();
        ex.createCriteria().andShopIdEqualTo(shopId);
        tShopConfigMapper.updateByExampleSelective(config, ex);
    }

    public List<TShopBusinessTime> selectTShopBusinessTime(int shopId){
        TShopBusinessTimeExample ex = new TShopBusinessTimeExample();
        ex.createCriteria().andShopIdEqualTo(shopId);
        return tShopBusinessTimeMapper.selectByExample(ex);
    }

    public List<TShopBusinessTime> getCurrentTimeInWork(int shopId) {
        List<TShopBusinessTime> timeNodes = selectTShopBusinessTime(shopId);
        // new Date(new Date().getTime() + 15 * 60 * 60 * 1000)
        LocalDateTime now = LocalDateTime.now();
        int todayWeek = now.getDayOfWeek();
        return timeNodes.stream()
                // filter 收集 当天的时间定义
                .filter(node -> node.getWeekDay() == todayWeek)
                // 在当天的开始时间之后并且在结束时间之前
                .filter(node -> {
                    LocalTime startTime = LocalTime.parse(node.getTimeStartNode());
                    LocalTime endTime = LocalTime.parse(node.getTimeEndNode());
                    LocalTime nowTime = now.toLocalTime();
                    return node.getOnline() == 1 && nowTime.isAfter(startTime) && nowTime.isBefore(endTime);
                }).collect(Collectors.toList());
    }

    public boolean currentTimeInWork(int shopId) {
        TShopConfigExample ex = new TShopConfigExample();
        ex.createCriteria().andShopIdEqualTo(shopId);
        TShopConfig config = Util.onlyOne(tShopConfigMapper.selectByExample(ex));
        if ( config.getInWork() == 1 ) {
            return getCurrentTimeInWork(shopId).size() > 0;
        } else {
            return false;
        }
    }
}


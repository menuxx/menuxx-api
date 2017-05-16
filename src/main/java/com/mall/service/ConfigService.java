package com.mall.service;

import com.mall.mapper.TConfigMapper;
import com.mall.model.TConfig;
import com.mall.model.TConfigExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConfigService {

    @Autowired
    TConfigMapper tConfigMapper;

    public List<TConfig> selectMyConfigs(Integer corpId) {
        TConfigExample ex = new TConfigExample();
        ex.createCriteria().andCorpIdEqualTo(corpId);
        return tConfigMapper.selectByExample(ex);
    }

    public Map<String, Integer> selectMyConfigs4Map(Integer corpId) {
        List<TConfig> list = selectMyConfigs(corpId);

        Map<String, Integer> map = new HashMap<>();

        for (TConfig config : list) {
            map.put(config.getName(), config.getValue());
        }

        return map;
    }
}

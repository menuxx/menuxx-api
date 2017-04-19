package com.mall.service;

import com.mall.mapper.TConfigMapper;
import com.mall.model.TConfig;
import com.mall.model.TConfigExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService {

    @Autowired
    TConfigMapper tConfigMapper;

    public List<TConfig> selectMyConfigs(Integer corpId) {
        TConfigExample ex = new TConfigExample();
        ex.createCriteria().andCorpIdEqualTo(corpId);
        return tConfigMapper.selectByExample(ex);
    }

}

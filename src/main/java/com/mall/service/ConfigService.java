package com.mall.service;

import com.mall.mapper.TConfigMapper;
import com.mall.model.TConfig;
import com.mall.model.TConfigExample;
import com.mall.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConfigService {

    @Autowired
    TConfigMapper tConfigMapper;

    public Integer saveBusinessTimeline(Integer corpId, String timeline) {
        TConfigExample ex = new TConfigExample();
        ex.createCriteria().andCorpIdEqualTo(corpId).andNameEqualTo("business_timeline");
        TConfig _config = Util.onlyOne(tConfigMapper.selectByExample(ex));
        // update
        if ( _config != null ) {
            TConfig _conf = new TConfig();
            _conf.setName("business_timeline");
            _conf.setValue(timeline);
            return tConfigMapper.updateByExampleSelective(_conf, ex);
        } else {
            TConfig newConfig = new TConfig();
            newConfig.setName("business_timeline");
            newConfig.setValue(timeline);
            newConfig.setCorpId(corpId);
            return tConfigMapper.insertSelective(newConfig);
        }
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
}

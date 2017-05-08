package com.mall.service.impl;

import com.mall.mapper.TSceneMapper;
import com.mall.model.TScene;
import com.mall.model.TSceneExample;
import com.mall.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yinchangsheng on 2017/5/8.
 */
@Service
public class SceneServiceImpl implements SceneService {

    @Autowired
    TSceneMapper tSceneMapper;

    @Override
    public List<TScene> getCorpSceneTabsWithEnable(int corpId) {
        TSceneExample ex = new TSceneExample();
        ex.createCriteria().andCorpIdEqualTo(corpId).andEnableEqualTo(1);
        ex.setOrderByClause("sort_num asc");
        return tSceneMapper.selectByExample(ex);
    }
}

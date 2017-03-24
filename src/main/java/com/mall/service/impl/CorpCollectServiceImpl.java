package com.mall.service.impl;

import com.mall.mapper.TCorpCollectMapper;
import com.mall.model.TCorpCollect;
import com.mall.service.CorpCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Supeng on 24/03/2017.
 */
@Service
public class CorpCollectServiceImpl implements CorpCollectService {

    @Autowired
    TCorpCollectMapper corpCollectMapper;

    @Override
    public void createCorpCollect(TCorpCollect corpCollect) {
        corpCollectMapper.insert(corpCollect);
    }
}

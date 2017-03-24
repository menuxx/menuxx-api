package com.mall.service.impl;

import com.mall.mapper.TCorpDiscoverMapper;
import com.mall.model.TCorpDiscover;
import com.mall.service.CorpDiscoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Supeng on 24/03/2017.
 */
@Service
public class CorpDiscoverServiceImpl implements CorpDiscoverService {

    @Autowired
    TCorpDiscoverMapper corpDiscoverMapper;

    @Override
    public void createCorpDiscover(TCorpDiscover corpDiscover) {
        corpDiscoverMapper.insert(corpDiscover);
    }
}

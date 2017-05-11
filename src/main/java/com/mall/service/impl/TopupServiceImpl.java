package com.mall.service.impl;

import com.mall.mapper.TTopupMapper;
import com.mall.model.TTopup;
import com.mall.model.TTopupExample;
import com.mall.service.TopupService;
import com.mall.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Supeng on 08/05/2017.
 */
@Service
public class TopupServiceImpl implements TopupService {

    @Autowired
    TTopupMapper topupMapper;

    @Override
    public List<TTopup> selectTopups(int corpId) {
        TTopupExample example = new TTopupExample();
        TTopupExample.Criteria criteria = example.createCriteria();

        criteria.andCorpIdEqualTo(corpId);

        return topupMapper.selectByExample(example);
    }

    @Override
    public TTopup selectTopup(int corpId, int topupId) {
        TTopupExample example = new TTopupExample();
        TTopupExample.Criteria criteria = example.createCriteria();

        criteria.andCorpIdEqualTo(corpId);
        criteria.andIdEqualTo(topupId);

        List<TTopup> list = topupMapper.selectByExample(example);

        return Util.onlyOne(list);
    }
}

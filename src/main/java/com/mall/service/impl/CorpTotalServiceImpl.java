package com.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.mall.mapper.TCorpTotalMapper;
import com.mall.model.TCorpTotal;
import com.mall.model.TCorpTotalExample;
import com.mall.model.TOrderExample;
import com.mall.service.CorpTotalService;
import com.mall.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Supeng on 31/03/2017.
 */
@Service
public class CorpTotalServiceImpl implements CorpTotalService {

    @Autowired
    TCorpTotalMapper corpTotalMapper;

    @Override
    public TCorpTotal selectCorpTotal(int corpId, Date day) {
        TCorpTotalExample example = new TCorpTotalExample();
        TCorpTotalExample.Criteria criteria = example.createCriteria();

        criteria.andCorpIdEqualTo(corpId);
        criteria.andDayEqualTo(day);

        List<TCorpTotal> list = corpTotalMapper.selectByExample(example);
        return Util.onlyOne(list);
    }

    @Override
    public void createCorpTotal(TCorpTotal corpTotal) {
        corpTotalMapper.insert(corpTotal);
    }

    @Override
    public PageInfo<TCorpTotal> selectCorpTotal(int corpId) {
        TCorpTotalExample example = new TCorpTotalExample();
        TCorpTotalExample.Criteria criteria = example.createCriteria();

        example.setOrderByClause(" ID DESC ");

        criteria.andCorpIdEqualTo(corpId);

        PageInfo<TCorpTotal> pageInfo = new PageInfo<>(corpTotalMapper.selectByExample(example));
        return pageInfo;
    }
}

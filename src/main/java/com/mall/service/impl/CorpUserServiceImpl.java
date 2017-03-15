package com.mall.service.impl;

import com.mall.mapper.TCorpUserMapper;
import com.mall.model.TCorpUser;
import com.mall.model.TCorpUserExample;
import com.mall.service.CorpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Supeng on 15/03/2017.
 */
@Service
public class CorpUserServiceImpl implements CorpUserService {

    @Autowired
    TCorpUserMapper corpUserMapper;

    @Override
    public List<TCorpUser> selectCorpUsersByCorpId(int corpId) {
        TCorpUserExample example = new TCorpUserExample();
        TCorpUserExample.Criteria criteria = example.createCriteria();

        criteria.andCorpIdEqualTo(corpId);

        return corpUserMapper.selectByExample(example);
    }
}

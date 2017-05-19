package com.mall.service.impl;

import com.mall.mapper.TCorpUserMapper;
import com.mall.model.TCorpUser;
import com.mall.model.TCorpUserExample;
import com.mall.service.CorpUserService;
import com.mall.utils.Util;
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

    @Override
    public TCorpUser selectCorpUserByMobile(String mobile) {
        TCorpUserExample example = new TCorpUserExample();
        TCorpUserExample.Criteria criteria = example.createCriteria();

        criteria.andMobileEqualTo(mobile);

        List<TCorpUser> list = corpUserMapper.selectByExample(example);

        TCorpUser user = Util.onlyOne(list);
        return user;
    }

    @Override
    public void updateCorpUser(TCorpUser corpUser) {
        corpUserMapper.updateByPrimaryKey(corpUser);
    }

    @Override
    public TCorpUser selectCorpUser(int corpUserId) {
        return corpUserMapper.selectByPrimaryKey(corpUserId);
    }

    @Override
    public void createCorpUser(TCorpUser corpUser) {
        corpUserMapper.insert(corpUser);
    }

    @Override
    public List<TCorpUser> selectAllCorpUsers() {
        return corpUserMapper.selectByExample(new TCorpUserExample());
    }
}

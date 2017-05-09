package com.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.mall.mapper.TRechargeRecordMapper;
import com.mall.model.TRechargeRecord;
import com.mall.model.TRechargeRecordExample;
import com.mall.service.RechargeRecordService;
import com.mall.utils.Constants;
import com.mall.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Supeng on 08/05/2017.
 */
@Service
public class RechargeRecordServiceImpl implements RechargeRecordService {

    @Autowired
    TRechargeRecordMapper rechargeRecordMapper;

    @Override
    public void createRechargeRecord(TRechargeRecord rechargeRecord) {
        rechargeRecordMapper.insert(rechargeRecord);
    }

    @Override
    public TRechargeRecord selectRechargeRecordByCode(String recordCode) {
        TRechargeRecordExample example = new TRechargeRecordExample();
        TRechargeRecordExample.Criteria criteria = example.createCriteria();

        criteria.andRechargeCodeEqualTo(recordCode);

        List<TRechargeRecord> list = rechargeRecordMapper.selectByExample(example);

        return Util.onlyOne(list);
    }

    @Override
    public void updateRechargeRecordStatus2Completed(int recordId) {
        TRechargeRecord rechargeRecord = new TRechargeRecord();
        rechargeRecord.setId(recordId);
        rechargeRecord.setStatus(Constants.ONE);

        rechargeRecordMapper.updateByPrimaryKeySelective(rechargeRecord);
    }

    @Override
    public PageInfo<TRechargeRecord> selectRechargeRecordByUser(int userId, int corpId) {
        TRechargeRecordExample example = new TRechargeRecordExample();
        TRechargeRecordExample.Criteria criteria = example.createCriteria();

        example.setOrderByClause("id desc");

        criteria.andUserIdEqualTo(userId);
        criteria.andCorpIdEqualTo(corpId);

        PageInfo<TRechargeRecord> pageInfo = new PageInfo<>(rechargeRecordMapper.selectByExample(example));
        return pageInfo;
    }
}

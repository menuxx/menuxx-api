package com.mall.service.impl;

import com.mall.mapper.TChargeApplyMapper;
import com.mall.model.Order;
import com.mall.model.TChargeApply;
import com.mall.model.TChargeApplyExample;
import com.mall.service.ChargeApplyService;
import com.mall.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Supeng on 01/03/2017.
 */
@Service
public class ChargeApplyServiceImpl implements ChargeApplyService {

    @Autowired
    TChargeApplyMapper chargeApplyMapper;

    @Override
    public void createChargeApply(TChargeApply chargeApply) {
        chargeApplyMapper.insert(chargeApply);
    }

    @Override
    public TChargeApply selectChargeApplyByOutTradeNo(String outTradeNo) {
        TChargeApplyExample example = new TChargeApplyExample();
        TChargeApplyExample.Criteria criteria = example.createCriteria();

        criteria.andOutTradeNoEqualTo(outTradeNo);

        TChargeApply chargeApply = Util.onlyOne(chargeApplyMapper.selectByExample(example));
        return chargeApply;
    }
}

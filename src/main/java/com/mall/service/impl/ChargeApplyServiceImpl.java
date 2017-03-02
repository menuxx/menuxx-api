package com.mall.service.impl;

import com.mall.mapper.TChargeApplyMapper;
import com.mall.model.Order;
import com.mall.model.TChargeApply;
import com.mall.service.ChargeApplyService;
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
    public void createChargeApply(Order order) {
        TChargeApply chargeApply = new TChargeApply();

        chargeApply.setUserId(order.getUserId());
        chargeApply.setOrderId(order.getId());
        chargeApply.setOuttradeno(order.getOrderCode());
//        chargeApply.setBody(scanPayReqData.getBody());
        chargeApply.setAmount(order.getPayAmount());
        chargeApply.setStatus(Order.STATUS_CREATED);

        chargeApplyMapper.insert(chargeApply);
    }
}

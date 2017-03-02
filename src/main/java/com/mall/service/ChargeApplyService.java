package com.mall.service;

import com.mall.model.Order;
import com.mall.model.TChargeApply;

/**
 * Created by Supeng on 01/03/2017.
 */
public interface ChargeApplyService {

    void createChargeApply(TChargeApply chargeApply);

    TChargeApply selectChargeApplyByOutTradeNo(String outTradeNo);

}

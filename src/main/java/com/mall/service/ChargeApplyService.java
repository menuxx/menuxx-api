package com.mall.service;

import com.mall.model.Order;
import com.tencent.protocol.pay_protocol.ScanPayReqData;

/**
 * Created by Supeng on 01/03/2017.
 */
public interface ChargeApplyService {

    void createChargeApply(Order order, ScanPayReqData scanPayReqData);

}

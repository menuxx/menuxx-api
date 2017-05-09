package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.model.TRechargeRecord;

/**
 * Created by Supeng on 08/05/2017.
 */
public interface RechargeRecordService {

    void createRechargeRecord(TRechargeRecord rechargeRecord);

    TRechargeRecord selectRechargeRecordByCode(String recordCode);

    void updateRechargeRecordStatus2Completed(int recordId);

    PageInfo<TRechargeRecord> selectRechargeRecordByUser(int userId, int corpId);
}

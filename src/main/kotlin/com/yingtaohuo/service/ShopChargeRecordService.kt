package com.yingtaohuo.service

import com.github.pagehelper.PageInfo
import com.mall.mapper.TShopChargeRecordMapper
import com.mall.model.TShopChargeRecord
import com.mall.model.TShopChargeRecordExample
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/16
 * 微信: yin80871901
 */

val ShopChargeRecordConsumeType_ImdadaTransport = 1

@Service
open class ShopChargeRecordService(val shopChargeRecordMapper : TShopChargeRecordMapper) {

    fun recordConsume(shopId: Int, shopAccountId: Int, amount: Int, consumeType: Int, remark: String) : TShopChargeRecord {
        val record = TShopChargeRecord()
        record.amount = amount
        record.consumeType = consumeType
        record.remark = remark
        record.shopId = shopId
        record.userId = shopAccountId
        record.chargeType = 0
        shopChargeRecordMapper.insertSelective(record)
        return record
    }

    fun selectList(corpId: Int) : PageInfo<TShopChargeRecord> {

        val ex = TShopChargeRecordExample()

        ex.createCriteria().andShopIdEqualTo(corpId)

        return PageInfo(shopChargeRecordMapper.selectByExample(ex))

    }

}

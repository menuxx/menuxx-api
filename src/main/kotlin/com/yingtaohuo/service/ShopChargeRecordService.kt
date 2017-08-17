package com.yingtaohuo.service

import com.github.pagehelper.PageInfo
import com.mall.mapper.TShopChargeRecordBalanceMapper
import com.mall.mapper.TShopChargeRecordMapper
import com.mall.model.TShopChargeRecord
import com.mall.model.TShopChargeRecordBalance
import com.mall.model.TShopChargeRecordBalanceExample
import com.mall.model.TShopChargeRecordExample
import com.mall.utils.Util
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/16
 * 微信: yin80871901
 */

val ShopChargeRecordConsumeType_ImdadaTransport = 1

@Service
open class ShopChargeRecordService(
        val shopChargeRecordMapper : TShopChargeRecordMapper,
        val balanceMapper: TShopChargeRecordBalanceMapper
) {

    @Transactional
    open fun recordConsume(shopId: Int, shopAccountId: Int, amount: Int, consumeType: Int, remark: String) : TShopChargeRecord {
        val record = TShopChargeRecord()
        record.amount = amount
        record.consumeType = consumeType
        record.remark = remark
        record.shopId = shopId
        record.userId = shopAccountId
        record.chargeType = 0
        record.type = -1
        shopChargeRecordMapper.insertSelective(record)

        // 如果没有月记录就创建余额记录
        var balance = getShopBalance(shopId)

        if ( balance == null ) {
            balance = createShopBalance(shopId)
        }

        // 计算余额
        updateShopBalance(shopId, balance.balance - amount)

        return record
    }

    open fun selectList(shopId: Int) : PageInfo<TShopChargeRecord> {
        val ex = TShopChargeRecordExample()
        ex.createCriteria().andShopIdEqualTo(shopId)
        return PageInfo(shopChargeRecordMapper.selectByExample(ex))
    }

    open fun getShopBalance(shopId: Int) : TShopChargeRecordBalance? {
        val ex = TShopChargeRecordBalanceExample()
        ex.createCriteria().andShopIdEqualTo(shopId)
        return Util.onlyOne(balanceMapper.selectByExample(ex))
    }

    open fun createShopBalance(shopId: Int) : TShopChargeRecordBalance {
        val ex = TShopChargeRecordBalanceExample()
        ex.createCriteria().andShopIdEqualTo(shopId)

        val record = TShopChargeRecordBalance()
        record.balance = 0
        record.shopId = shopId

        balanceMapper.insertSelective(record)

        return record
    }

    open fun updateShopBalance(shopId: Int, balance: Int) : Int {

        val ex = TShopChargeRecordBalanceExample()
        ex.createCriteria().andShopIdEqualTo(shopId)

        val record = TShopChargeRecordBalance()
        record.balance = balance
        record.shopId = shopId

        return balanceMapper.updateByExampleSelective(record, ex)
    }

}

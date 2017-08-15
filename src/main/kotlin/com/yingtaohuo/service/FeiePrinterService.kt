package com.yingtaohuo.service

import com.mall.mapper.TFeiePrinterMapper
import com.mall.model.TFeiePrinter
import com.mall.model.TFeiePrinterExample
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/15
 * 微信: yin80871901
 */
@Service
open class FeiePrinterService(val feiePrinterMapper: TFeiePrinterMapper) {

    fun selectShopPrinter(shopId: Int) : List<TFeiePrinter> {
        val ex = TFeiePrinterExample()
        ex.createCriteria().andShopIdEqualTo(shopId)
        return feiePrinterMapper.selectByExample(ex)
    }

}
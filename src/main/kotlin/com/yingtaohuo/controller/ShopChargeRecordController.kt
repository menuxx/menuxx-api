package com.yingtaohuo.controller

import com.github.pagehelper.PageInfo
import com.mall.configure.page.Page
import com.mall.model.TShopChargeRecord
import com.mall.model.TShopChargeRecordBalance
import com.mall.utils.Constants
import com.yingtaohuo.service.ShopChargeRecordService
import org.springframework.web.bind.annotation.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/16
 * 微信: yin80871901
 */
@RestController
@RequestMapping("/diners/{shopId}")
open class ShopChargeRecordController(val shopChargeRecordService: ShopChargeRecordService) {

    data class ShopChargeRecord(val balance: Int, val page: PageInfo<TShopChargeRecord>)
    @Page
    @GetMapping("shop_charge_record")
    open fun getListOfPage(
            @PathVariable shopId: Int,
            @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGENUM) pageNum : Int,
            @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGESIZE) pageSize: Int
    ) : ShopChargeRecord {
        val page = shopChargeRecordService.selectList(shopId)
        val balance = shopChargeRecordService.getShopBalance(shopId) ?: TShopChargeRecordBalance()
        return ShopChargeRecord(balance.balance ?: 0, page)
    }


}
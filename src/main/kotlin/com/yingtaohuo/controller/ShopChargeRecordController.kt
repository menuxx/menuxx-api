package com.yingtaohuo.controller

import com.mall.configure.page.Page
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

    @Page
    @GetMapping("shop_charge_record")
    open fun getListOfPage(
            @PathVariable shopId: Int,
            @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGENUM) pageNum : Int,
            @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGESIZE) pageSize: Int
    ) = shopChargeRecordService.selectList(shopId)

}
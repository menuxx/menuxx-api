package com.yingtaohuo.controller

import com.mall.model.Order
import com.mall.service.CorpService
import com.mall.wrapper.OrderWrapper
import com.yingtaohuo.feieprinter.FeieOrderPrinter
import com.yingtaohuo.mode.ResponseDataWrap
import org.springframework.web.bind.annotation.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/31
 * 微信: yin80871901
 */
@RestController
@RequestMapping("/diners/{shopId}")
class PrintController(
        private val feieOrderPrinter: FeieOrderPrinter,
        private val orderWrapper: OrderWrapper,
        private val corpService: CorpService
) {

    data class OrderPrint(val orderId: Int, val order: Order?=null)
    @PostMapping("/printer/feie")
    fun feiePrintOrder(@PathVariable shopId: Int, @RequestBody print: OrderPrint) : ResponseDataWrap {
        val shop = corpService.selectCorpByCorpId(shopId)
        val order = print.order ?: orderWrapper.selectOrder(print.orderId)
        val allSuccessPrinted = feieOrderPrinter.printOrderToShop(order, shop)
        return ResponseDataWrap(allSuccessPrinted, 0, fireError = !allSuccessPrinted)
    }

}
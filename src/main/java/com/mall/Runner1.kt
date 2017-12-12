package com.mall

import com.mall.model.TItem
import com.mall.model.TOrderItem
import com.mall.service.CorpService
import com.mall.service.ItemService
import com.mall.service.OrderItemService
import com.mall.service.StatisticsService
import com.mall.wrapper.OrderWrapper
import com.yingtaohuo.feieprinter.FeieOrderPrinter
import com.yingtaohuo.service.CouponService
import com.yingtaohuo.service.FeiePrinterService
import com.yingtaohuo.service.ShopConfigService
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/10
 * 微信: yin80871901
 */
@Profile("development")
@Component
class Runner1(
        private val orderItemService: OrderItemService,
        private val itemService: ItemService
        ) : CommandLineRunner {

    private fun getGoodsRemark(orderItems: List<TOrderItem>, itemMap: Map<Int, TItem>) : String {
        return orderItems.joinToString(",") { item -> "${itemMap[item.itemId]?.itemName}x${item.quantity}" }
    }

    override fun run(vararg args: String?) {
        val orderItems = orderItemService.selectOrderItemByOrderId(21)
        val itemMap = itemService.selectItemsForMap(orderItems.map { it.itemId }.toList())
        val goodsRemark = getGoodsRemark(orderItems, itemMap)
        println(goodsRemark)
    }
}

@Profile("dproduction")
@Component
class Runner2(
        private val couponService: CouponService,
        private val feieOrderPrinter: FeieOrderPrinter,
        private val orderWrapper: OrderWrapper,
        private val corpService: CorpService,
        private val shopConfigService: ShopConfigService
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        val order = orderWrapper.selectOrder(20729)

        val shop = corpService.selectCorpByCorpId(58)

        val config = shopConfigService.getShopConfig(58)

        feieOrderPrinter.printOrderToShop(order, shop, config)

//        statisticsService.doStatistics("2017-11-09")
//        statisticsService.doStatistics("2017-11-10")
//        statisticsService.doStatistics("2017-11-11")
//        statisticsService.doStatistics("2017-11-12")
    }

}
package com.yingtaohuo.service

import com.mall.model.Order
import com.mall.push.DinerPushManager
import com.mall.service.CorpService
import com.mall.service.CorpUserService
import com.mall.wrapper.OrderWrapper
import com.yingtaohuo.feieprinter.FeieOrderPrinter
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/2
 * 微信: yin80871901
 */
@Service
open class PushService(
        val feieOrderPrinter: FeieOrderPrinter,
        val pushManager: DinerPushManager, val orderWrapper: OrderWrapper,
        val corpService: CorpService,
        val corpUserService: CorpUserService,
        val wxlitePush: WXLiteMQTTPush
) {

    // 推送确认订单
    // 大店版，点单后不需要支付，直接打单
    fun pushConfirmOrder(shopId: Int, order: Order) {
        val corp = corpService.selectCorpByCorpId(order.corpId)
        val corpUserList = corpUserService.selectCorpUsersByCorpId(shopId)
        for (corpUser in corpUserList) {
            pushManager.pushOrderToShopReceiver(corpUser.pushKey, order)
        }
        // 推送到飞蛾打印机
        feieOrderPrinter.printOrderToShop(order, corp)
    }

    // 推送已经完成支付的订单
    fun pushPaidOrder(order: Order) {
        val corp = corpService.selectCorpByCorpId(order.corpId)
        val corpUserList = corpUserService.selectCorpUsersByCorpId(order.corpId)
        for (corpUser in corpUserList) {
            pushManager.pushOrderToShopReceiver(corpUser.pushKey, order)
        }
        // 推送到飞蛾打印机
        feieOrderPrinter.printOrderToShop(order, corp)
        wxlitePush.orderPaid(order.userId, order.id)
    }

    fun pushPaidOrderWithOrderId(orderId: Int) = pushPaidOrder(orderWrapper.selectOrder(orderId))

}
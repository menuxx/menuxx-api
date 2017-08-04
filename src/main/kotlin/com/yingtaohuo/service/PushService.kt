package com.yingtaohuo.service

import com.mall.model.Order
import com.mall.push.DinerPushManager
import com.mall.service.CorpUserService
import com.mall.wrapper.OrderWrapper
import com.yingtaohuo.eventbus.OrderAddItems
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/2
 * 微信: yin80871901
 */
@Service
class PushService(
        val pushManager: DinerPushManager, val orderWrapper: OrderWrapper,
        val corpUserService: CorpUserService
) {

    // 推送确认订单
    // 大店版，点单后不需要支付，直接打单
    fun pushConfirmOrder(shopId: Int, order: Order) {
        val corpUserList = corpUserService.selectCorpUsersByCorpId(shopId)
        for (corpUser in corpUserList) {
            pushManager.pushOrderToShopReceiver(corpUser.pushKey, order)
        }
    }

    // 推送已经完成支付的订单
    fun pushPaidOrder(order: Order) {
        val corpUserList = corpUserService.selectCorpUsersByCorpId(order.corpId)
        for (corpUser in corpUserList) {
            pushManager.pushOrderToShopReceiver(corpUser.pushKey, order)
        }
    }

    fun pushPaidOrderWithOrderId(orderId: Int) = pushPaidOrder(orderWrapper.selectOrder(orderId))

    // 推送订单追加的商品
    fun pushOrderAddItems(shopId: Int, items: OrderAddItems) {
        val corpUserList = corpUserService.selectCorpUsersByCorpId(shopId)
        for (corpUser in corpUserList) {
            pushManager.pushOrderAddItemsToShopReceiver(corpUser.pushKey, items)
        }
    }

}
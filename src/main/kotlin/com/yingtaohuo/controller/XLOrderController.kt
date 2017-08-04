package com.yingtaohuo.controller

import com.mall.mapper.TOrderMapper
import com.mall.model.Order
import com.mall.model.OrderItem
import com.mall.model.TOrderItem
import com.mall.wrapper.OrderItemWrapper
import com.mall.wrapper.OrderWrapper
import com.yingtaohuo.eventbus.OrderAddItems
import com.yingtaohuo.mode.ResponseDataWrap
import com.yingtaohuo.service.PushService
import com.yingtaohuo.service.XLOrderService
import org.springframework.web.bind.annotation.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/27
 * 微信: yin80871901
 *
 * 中大店订单
 */

@RestController
@RequestMapping("/diners/{dinerId}")
open class XLOrderController(
        internal val orderService: XLOrderService,
        internal val pushService: PushService,
        internal val orderWrapper: OrderWrapper,
        internal val orderMapper: TOrderMapper
) {

    data class OrderItems(val remark: String, val items: List<TOrderItem>)
    @PutMapping("orders/{orderId}/items")
    fun appendItemsToOrder(@PathVariable orderId: Int, orderItems: OrderItems) {
        val newOrderItem = orderService.insertItems(orderId, orderItems.items)
        val order = orderMapper.selectByPrimaryKey(orderId)
        pushService.pushOrderAddItems(order.corpId, OrderAddItems(orderId, orderItems.remark, newOrderItem))
    }

    /**
     * 订单状态变更为支付
     * 订单支付状态变更推送
     */
    @PutMapping("orders/{orderId}/paid")
    fun orderStatusApplyPaid(@PathVariable orderId: Int) : ResponseDataWrap {
        // 状态修改
        if ( orderService.applyOrderStatus(orderId, Order.STATUS_PAID) > 0 ) {
            // 订单推送
            pushService.pushPaidOrderWithOrderId(orderId)
            return ResponseDataWrap(null, 0, false)
        }
        return ResponseDataWrap(null, 4002, true)
    }

}
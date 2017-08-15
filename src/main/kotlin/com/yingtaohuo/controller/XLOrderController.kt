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
    fun appendItemsToOrder(@PathVariable dinerId: Int, @PathVariable orderId: Int, @RequestBody orderItems: OrderItems) : ResponseDataWrap {
        try {

            // 捏造一个部分商品的订单，该订单只显追加商品的信息

            // 查询出该订单详细信息
            val newOrderItems = orderService.insertItems(orderId, orderItems.items, orderItems.remark)
            val order = orderWrapper.selectOrder(orderId)

            // 覆盖所有商品，只计算新商品的数据
            order.itemList = newOrderItems

            orderWrapper.calcOrder(order)

            pushService.pushConfirmOrder(dinerId, order)

        } catch (ex: Exception) {
            return ResponseDataWrap(false, 4003, false)
        }

        return ResponseDataWrap(true, 0, false)
    }

    /**
     * 订单状态变更为支付
     * 订单支付状态变更推送
     */
    @PutMapping("orders/{orderId}/paid")
    fun orderStatusApplyPaid(@PathVariable orderId: Int) : ResponseDataWrap {
        // 状态修改
        if ( orderService.applyOrderStatus(orderId, Order.STATUS_OFFLINE) > 0 ) {
            // 订单推送
            pushService.pushPaidOrderWithOrderId(orderId)
            return ResponseDataWrap(null, 0, false)
        }
        return ResponseDataWrap(null, 4002, true)
    }

    @GetMapping("orders/{orderId}/state")
    fun orderState(@PathVariable orderId: Int) : ResponseDataWrap {
        val order = orderMapper.selectByPrimaryKey(orderId)
        return ResponseDataWrap(order.status, 0, false)
    }

}
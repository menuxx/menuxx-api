package com.yingtaohuo.controller

import com.google.common.eventbus.EventBus
import com.mall.AllOpen
import com.mall.mapper.TOrderMapper
import com.mall.model.Order
import com.mall.model.TOrderItem
import com.mall.service.ItemService
import com.mall.wrapper.OrderWrapper
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

@AllOpen
@RestController
@RequestMapping("/diners/{dinerId}")
class XLOrderController(
        private val orderService: XLOrderService,
        private val pushService: PushService,
        private val orderWrapper: OrderWrapper,
        private val orderMapper: TOrderMapper,
        private val itemService: ItemService,
        private val eventBus: EventBus
) {

    data class OrderItems(val remark: String?, val items: List<TOrderItem>)
    @PutMapping("orders/{orderId}/items")
    fun appendItemsToOrder(@PathVariable dinerId: Int, @PathVariable orderId: Int, @RequestBody orderItems: OrderItems) : ResponseDataWrap {
        try {

            val itemMap = itemService.selectItemsForMap(orderItems.items.map { item->item.itemId })

            // 捏造一个部分商品的订单，该订单只显追加商品的信息

            // 查询出该订单详细信息
            val newOrderItems = orderService.insertItems(orderId, orderItems.items, orderItems.remark)
            val order = orderWrapper.selectOrder(orderId)

            // 覆盖所有商品，只计算新商品的数据
            order.itemList = newOrderItems

            orderWrapper.calcOrder(order, itemMap, false)

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
        val order = orderMapper.selectByPrimaryKey(orderId)
        if ( order != null && (order.status != Order.STATUS_PAID &&  order.status != Order.STATUS_OFFLINE) ) {
            // 状态修改
            if ( orderService.applyOrderStatus(orderId, Order.STATUS_OFFLINE) > 0 ) {
                // 订单推送
                pushService.pushPaidOrderWithOrderId(orderId)

                // 发布支付事件
                order.status = Order.STATUS_OFFLINE
                eventBus.post(order)

                return ResponseDataWrap(null, 0, false)
            }
            return ResponseDataWrap(null, -1, true)
        }
        return ResponseDataWrap(null, -2, true)
    }

    @GetMapping("orders/{orderId}/state")
    fun orderState(@PathVariable orderId: Int) : ResponseDataWrap {
        val order = orderMapper.selectByPrimaryKey(orderId)
        return ResponseDataWrap(order.status, 0, false)
    }

}
package com.yingtaohuo.service

import com.mall.mapper.TOrderItemMapper
import com.mall.mapper.TOrderMapper
import com.mall.model.OrderItem
import com.mall.model.TOrder
import com.mall.model.TOrderItem
import com.mall.model.TOrderItemExample
import com.mall.service.ItemService
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/27
 * 微信: yin80871901
 */
@Service
class XLOrderService(
        internal val orderMapper: TOrderMapper,
        internal val orderItemMapper: TOrderItemMapper,
        internal val itemService: ItemService
) {

    fun insertItems(orderId: Int, orderItems: List<TOrderItem>) : List<OrderItem> {
        // 获取所有需要参与计算的商品详细信息
        val selectItems = itemService.selectItemsForMap(orderItems.map { it.itemId })

        // 获取该笔订单下面的所有商品
        val ex  = TOrderItemExample()
        ex.createCriteria().andOrderIdEqualTo(orderId)
        val oldItems = orderItemMapper.selectByExample(ex)

        // 找出只是数量增加的 商品 并更新数量和支付金额
        // quantity pay_amount
        orderItems.filter { new ->
            when(oldItems.findLast { old -> old.itemId == new.itemId }) {
                null -> false
                else -> true
            }
        } .map { item ->
            item.payAmount = selectItems[item.itemId]!!.discountPrice * item.quantity
            orderItemMapper.updateByPrimaryKey(item)
            item
        }

        // 找出新添加的商品， 计算 pay_amount 插入数据库
        val items2 = orderItems.filter { new ->
            when(oldItems.findLast { old -> old.itemId == new.itemId }) {
                null -> false
                else -> true
            }
        } .map { item ->
            item.orderId = orderId
            item.payAmount = selectItems[item.itemId]!!.discountPrice * item.quantity
            orderItemMapper.insertSelective(item)
            item
        } .map { item ->
            OrderItem(item, selectItems[item.itemId])
        }

        return items2

    }

    /**
     * 订单状态更新
     */
    fun applyOrderStatus(orderId: Int, status: Int) : Int {
        val order = TOrder()
        order.id = orderId
        order.status = status
        return orderMapper.updateByPrimaryKeySelective(order)
    }

}
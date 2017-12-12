package com.yingtaohuo.service

import com.mall.mapper.TOrderItemMapper
import com.mall.mapper.TOrderMapper
import com.mall.model.*
import com.mall.service.ItemService
import com.mall.utils.Util
import com.mall.wrapper.OrderWrapper
import org.apache.commons.lang3.StringUtils
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/27
 * 微信: yin80871901
 */
@Service
class XLOrderService(
        private val orderMapper: TOrderMapper,
        private val orderItemMapper: TOrderItemMapper,
        private val itemService: ItemService,
        private val orderWrapper: OrderWrapper,
        private val activityOrderService: ActivityOrderService
) {

    private fun getDeaPrice(tItem: TItem): Int {
        // 今日特价
        return if (Util.getWeekday() == tItem.weekday) {
            tItem.specialPrice
        } else {
            tItem.discountPrice
        }
    }

    fun insertItems(orderId: Int, orderItems: List<TOrderItem>, remark: String?) : List<OrderItem> {
        // 获取所有需要参与计算的商品详细信息
        val selectItems = itemService.selectItemsForMap(orderItems.map { it.itemId })

        // 获取该笔订单下面的所有商品
        val ex  = TOrderItemExample()
        ex.createCriteria().andOrderIdEqualTo(orderId)
        val oldItems = orderItemMapper.selectByExample(ex)

        // 找出只是数量增加的 商品 并更新数量和支付金额
        // quantity pay_amount
        val items1 =  orderItems.filter { new ->
            when(oldItems.findLast { old -> old.itemId == new.itemId }) {
                null -> false
                else -> true
            }
        } .map { item ->
            // 取得之前 商品的 quantity
            // 取的之前 商品的 payAmount
            val existsItem =  oldItems.findLast { old -> old.itemId == item.itemId }
            existsItem!!.dealPrice = getDeaPrice(selectItems[item.itemId]!!)
            item.payAmount = existsItem.dealPrice * item.quantity
            existsItem.payAmount += item.payAmount
            existsItem.quantity += item.quantity
            orderItemMapper.updateByPrimaryKey(existsItem)
            item
        } .map { item ->
            OrderItem(item, selectItems[item.itemId])
        }

        // 找出新添加的商品， 计算 pay_amount 插入数据库
        val items2 = orderItems.filter { new ->
            when(oldItems.findLast { old -> old.itemId == new.itemId }) {
                null -> true
                else -> false
            }
        } .map { item ->
            item.orderId = orderId
            item.dealPrice = getDeaPrice(selectItems[item.itemId]!!)
            item.payAmount = item.dealPrice * item.quantity
            orderItemMapper.insertSelective(item)
            item
        } .map { item ->
            OrderItem(item, selectItems[item.itemId])
        }

        // 获取该订单
        val order = orderWrapper.selectOrder(orderId)

        // 重新计算后的订单
        // 计算满减活动后的价格
        val calcedOrder = activityOrderService.calcActivityMinusOrder(order, orderItems)

        // 下单次数累加
        calcedOrder.orderTimes = order.orderTimes + 1

        if ( !StringUtils.isBlank(remark) ) {
            if ( StringUtils.isBlank(order.remark) ) {
                calcedOrder.remark = remark
            }
            else {
                calcedOrder.remark = remark + ", " +order.remark
            }
        }

        // 更新该订单
        orderMapper.updateByPrimaryKeySelective(calcedOrder)

        return items2 + items1

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
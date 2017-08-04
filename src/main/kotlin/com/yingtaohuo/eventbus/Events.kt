package com.yingtaohuo.eventbus

import com.mall.model.OrderItem

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/27
 * 微信: yin80871901
 */
// 开桌订单
// data class NewOrder()

data class OrderAddItems(val orderId: Int, val remark: String, val items: List<OrderItem>)
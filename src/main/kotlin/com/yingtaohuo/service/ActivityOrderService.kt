package com.yingtaohuo.service

import com.mall.model.*
import com.mall.service.ItemService
import com.mall.service.UserService
import com.mall.utils.Util
import com.yingtaohuo.mode.ShopConfig
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/20
 * 微信: yin80871901
 */
@Service
open class ActivityOrderService(
        private val userService: UserService,
        private val configService: ShopConfigService,
        private val itemService: ItemService,
        private val activityService: ActivityService
) {

    /**
     * 成交价格前置处理
     */
    private fun preDealPrice(orderItems: List<TOrderItem>, itemMap: Map<Int, TItem>) {
        orderItems.forEach { item ->
            // 每日特价商品按特价处理
            val tItem = itemMap[item.itemId]
            if (Util.getWeekday() == tItem!!.weekday) {
                item.dealPrice = tItem.specialPrice
            } else {
                item.dealPrice = tItem.discountPrice
            }
        }
    }

    /**
     * 计算购买商品总价格
     */
    fun calcOrderItemsAmount(orderId: Int, orderItems: List<TOrderItem>, itemMap: Map<Int, TItem>) : Int {
        // 前置处理
        preDealPrice(orderItems, itemMap)
        return orderItems.map { item ->
            val payAmount = item.dealPrice * item.quantity
            item.payAmount = payAmount
            item.orderId = orderId
            payAmount
        }.sum()
    }

    /**
     * 计算打包价格
     */
    fun calcPackageFee(order: TOrder, orderItems: List<TOrderItem>, itemMap: Map<Int, TItem>, config: TShopConfig) : Int {
        // 只有外卖 和 打包才计算打包费
        var packageFee = 0
        if ( order.orderType == Order.ORDER_TYPE_DELIVERED || order.orderType == Order.ORDER_TYPE_CARRY_OUT) {
            packageFee = orderItems
                    .filter { item -> itemMap[item.itemId]!!.packageFlag == 1 }
                    .map { item -> item.quantity * config.packFee }.sum()
        }
        return packageFee
    }

    /**
     * 计算配送费价格
     */
    fun calcDeliveryFee(orderItemsAmount: Int, order: TOrder, config: TShopConfig) : Int {
        // 如果选择外卖，计入配送费
        var deliveryFee = 0
        if ( order.orderType == Order.ORDER_TYPE_DELIVERED ) {
            // 达到免配送金额，免配送费
            if (orderItemsAmount < config.deliveryNofeeLimit) {
                deliveryFee = config.deliveryFee
            } else {
                deliveryFee = 0
            }
            // 如果没有见面配送费的要求 任何情况都不减免配送费
            // 配送费就等于配置好的配送费
            if ( config.deliveryNofeeLimit == 0 ) {
                deliveryFee = config.deliveryFee
            }
        }
        return deliveryFee
    }

    // 计算满减订单价格
    fun calcActivityMinusOrder(order: TOrder, orderItems: List<TOrderItem>) : TOrder {
        val itemMap = itemService.selectItemsForMap(orderItems.map { item->item.itemId })

        // 计算得到只包含能参与满减的价格
        var payAmountOfMinus = 0
        val config = configService.getShopConfig(order.corpId)
        // 计算购买商品价格, 只计算参与满减活动的商品
        val orderItemsAmountOfMinus = calcOrderItemsAmount(order.id, orderItems.filter { item ->
            itemMap[item.itemId]!!.joinActMinus == 1
        }, itemMap)
        payAmountOfMinus += orderItemsAmountOfMinus

        val packageFee = calcPackageFee(order, orderItems, itemMap, config)
        payAmountOfMinus += packageFee

        val deliveryFee = calcDeliveryFee(orderItemsAmountOfMinus, order, config)
        payAmountOfMinus += deliveryFee

        return calcActivity(order, orderItemsAmountOfMinus)
    }

    // 卡券参与价格计算
    fun calcCoupons(order: TOrder, currentUserCoupons: List<TCoupon>) : TOrder {
        // 让新授权排在最先计算的位置，如果存在
        for (coupon in currentUserCoupons.sortedBy { coupon -> coupon.type }) {
            if (coupon.type == 1 || coupon.type == 3 || coupon.type == 5) {
                if ( order.payAmount >= coupon.toup ) {
                    order.payAmount -= coupon.cutback
                    order.couponId = coupon.id
                    break
                }
                //
            } else {
                order.payAmount = (order.payAmount * coupon.discount).toInt()
                order.couponId = coupon.id
                break
            }
        }
        return order
    }

    fun calcCoupon(order: TOrder, coupon: TCoupon) : TOrder {
        // 当卡券类型是 1，新人券 2 ，满减券 5，代金券 就启动满减计算方式
        if (coupon.type == 1 || coupon.type == 3 || coupon.type == 5) {
            if ( order.payAmount >= coupon.toup ) {
                order.payAmount -= coupon.cutback
                order.couponId = coupon.id
            }
            //
        } else {
            order.payAmount = (order.payAmount * coupon.discount).toInt()
            order.couponId = coupon.id
        }
        return order
    }

    // 计算参加活动后的价格
    private fun calcActivity(order: TOrder, payAmountOfMinus: Int): TOrder {
        val applyActivities = StringBuilder()
        val activities = activityService.selectShopAvailableActivity(order.corpId)
        // 如果该店有活动
        var i = 0
        if (activities?.isNotEmpty() == true) {
            loop@ for (activity in activities) {
                // 同时参加多个活动 满30减15,满50送菠萝
                // 追加活动分解符
                if (i > 1) {
                    applyActivities.append(",")
                }
                when (activity.type) {
                    1 // 1 .满减活动
                    -> {
                        val activityMinuses = activityService.selectAvailableActivityMinus(activity.id)
                        // 查找出一个 最接近的满减标准
                        val tams = activityMinuses.filter { am -> payAmountOfMinus >= am.toup }
                        if (tams.isNotEmpty()) {
                            val find = tams.reduce { _, b -> b }
                            val payAmount1 = order.payAmount - find.cutback
                            order.payAmount = payAmount1
                            applyActivities.append(find.descText)
                            // 如果不支持共享计算
                            // 退出循环
                            if (activity.shareCalc == 0) {
                                break@loop
                            }
                        }
                    }
                    2
                    -> {
                        val user = userService.selectUser(order.userId)
                        // 未消费过
                        if ( user.consumed < 1 ) {
                            val newUserActivities = activityService.selectAvailableActivityNewUser(activity.id)
                            if (newUserActivities.isNotEmpty()) {
                                val firstAct = newUserActivities[0]
                                // 计算折扣
                                if ( firstAct.discount != null ) {
                                    order.payAmount = (order.payAmount * firstAct.discount).toInt()
                                    applyActivities.append(firstAct.descText)
                                    // 计算满减
                                } else if ( firstAct.cutback != null && firstAct.toup != null ) {
                                    order.payAmount = order.payAmount - firstAct.cutback
                                    applyActivities.append(firstAct.descText)
                                }
                            }
                            if (activity.shareCalc == 0) {
                                break@loop
                            }
                        }
                    }
                }
                i++
            }
            // 该订单参加的活动
            order.applyActivities = applyActivities.toString()
        }
        return order
    }

}
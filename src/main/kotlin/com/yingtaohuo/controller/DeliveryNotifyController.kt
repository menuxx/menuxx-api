package com.yingtaohuo.controller

import cn.imdada.*
import com.mall.service.OrderService
import com.yingtaohuo.service.ShopChargeRecordConsumeType_ImdadaTransport
import com.yingtaohuo.service.ShopChargeRecordService
import com.yingtaohuo.service.TransportService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/16
 * 微信: yin80871901
 */
@RestController
open class DeliveryNotifyController(val transportService: TransportService,
                                    val orderService: OrderService,
                                    val shopChargeRecordService: ShopChargeRecordService) {
    @PostMapping("/imdada/callback")
    fun imDadaCallback(@RequestBody event: DDOrderEvent) : String {
        return when(event.orderStatus) {
            DDOrderEventStatusWaitForAccept -> "created"
            DDOrderEventStatusWaitForFetch -> {
                val ste = transportService.acceptOrder(
                        orderNo = event.orderId,
                        transportTel = event.dmMobile!!, transportNo = event.dmId!!, transportName = event.dmName!!
                )
                return if (ste > 0) "success" else "fail"
            }
            DDOrderEventStatusFinish -> {
                val ste = transportService.finishTransport(orderNo = event.orderId)

                if (ste > 0) {
                    // 如果接单，就开始扣费
                    val transport = transportService.getTransportByOrderNo(event.orderId)
                    val order = orderService.selectOrderByCode(event.orderId)
                    val amount = transport!!.transportFee + (transport.transportTips ?: 0)
                    // 记录消费
                    // 某个店铺 达达 消费
                    shopChargeRecordService.recordConsume(order.corpId, 0, amount, ShopChargeRecordConsumeType_ImdadaTransport, "达达配送费")
                }

                return if (ste > 0) "success" else "fail"
            }
            DDOrderEventStatusCancel -> {
                val ste = transportService.transportCancel(orderNo = event.orderId, reason = event.cancelReason)
                return if (ste > 0) "success" else "fail"
            }
            DDOrderEventStatusTransport -> {
                val ste = transportService.transportStatusUpdate(orderNo = event.orderId, status = TransportService.StatusTransport)
                return if (ste > 0) "success" else "fail"
            }
            DDOrderEventStatusExpire -> {

                val ste = transportService.transportStatusUpdate(orderNo = event.orderId, status = TransportService.StatusExpired)
                return if (ste > 0) "success" else "fail"
            }
            else -> {
                val ste = transportService.transportStatusUpdate(orderNo = event.orderId, status = event.orderStatus)
                return if (ste > 0) "success" else "fail"
            }
        }
    }
}
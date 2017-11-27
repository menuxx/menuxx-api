package com.yingtaohuo.controller

import cn.imdada.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.io.ByteStreams
import com.mall.service.OrderService
import com.yingtaohuo.service.*
import me.ele.delivery.*
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URLDecoder
import javax.servlet.http.HttpServletRequest

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/16
 * 微信: yin80871901
 */
@RestController
open class DeliveryNotifyController(
        private val objectMapper: ObjectMapper,
        private val deliveryService: DeliveryService,
                                    private val orderService: OrderService,
                                    private val shopChargeRecordService: ShopChargeRecordService) {
    @PostMapping("/imdada/callback")
    fun imDadaCallback(@RequestBody event: DDOrderEvent) : String {
        return when(event.orderStatus) {
            DDOrderEventStatusWaitForAccept -> "created"
            DDOrderEventStatusWaitForFetch -> {
                val ste = deliveryService.acceptOrder(
                        orderNo = event.orderId,
                        carrierTel = event.dmMobile!!, carrierName = event.dmName!!, carrierNo = event.dmId!!
                )
                return if (ste > 0) "success" else "fail"
            }
            DDOrderEventStatusFinish -> {
                val ste = deliveryService.finishOrder(orderNo = event.orderId)
                if (ste > 0) {
                    // 如果接单，就开始扣费
                    val delivery = deliveryService.getByOrderNo(event.orderId)
                    val order = orderService.selectOrderByCode(event.orderId)
                    val amount = delivery!!.deliveryFee + (delivery.deliveryTips ?: 0)
                    // 记录消费
                    // 某个店铺 达达 消费
                    shopChargeRecordService.recordConsume(order.corpId, 0, amount, ShopChargeRecordConsumeType_ImdadaDelivery, "达达配送费")
                }
                return if (ste > 0) "success" else "fail"
            }
            DDOrderEventStatusCancel -> {
                val ste = deliveryService.orderCancel(orderNo = event.orderId, reason = event.cancelReason)
                return if (ste > 0) "success" else "fail"
            }
            DDOrderEventStatusTransport -> {
                val ste = deliveryService.updateDeliveryOrderStatus(orderNo = event.orderId, status = DeliveryService.StatusDeliverying)
                return if (ste > 0) "success" else "fail"
            }
            DDOrderEventStatusExpire -> {
                val ste = deliveryService.updateDeliveryOrderStatus(orderNo = event.orderId, status = DeliveryService.StatusExpired)
                return if (ste > 0) "success" else "fail"
            }
            else -> {
                val ste = deliveryService.updateDeliveryOrderStatus(orderNo = event.orderId, status = event.orderStatus)
                return if (ste > 0) "success" else "fail"
            }
        }
    }

    @PostMapping("/ele/callback", consumes = arrayOf(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
    fun imEleCallback(@RequestBody jsonTextHasUrlencoded: String) : String {
        // data="body"
        var str = ""
        if (jsonTextHasUrlencoded.startsWith("data=")) {
            str = str.replace("data=", "")
        }
        if (jsonTextHasUrlencoded.startsWith("event=")) {
            str = jsonTextHasUrlencoded.replace("event=ele_push_order", "")
        }
        if (str.startsWith("&data=")) {
            str = str.replace("&data=", "")
        }
        val jsonText = URLDecoder.decode(str, "UTF-8")
        val event = objectMapper.readValue<EleOrderEvent>(jsonText, EleOrderEvent::class.java)
        return when(event.orderStatus) {
            // 系统已接单
            EleOrderStatusOfAccept -> {
                // 状态城改为待接单
                val ste = deliveryService.updateDeliveryOrderStatus(orderNo = event.partnerOrderCode, status = DeliveryService.StatusWaitForFetch)
                return if (ste > 0) "success" else "fail"
            }
            // 系统拒单/配送异常
            EleOrderStatusOfFail -> {
                val ste = deliveryService.orderCancel(orderNo = event.partnerOrderCode, reason = event.errorCode + ", " + event.cancelReason)
                return if (ste > 0) "success" else "fail"
            }
            // 已送达
            EleOrderStatusOfArrive -> {
                // 扣费记录
                val ste = deliveryService.finishOrder(orderNo = event.partnerOrderCode)
                if (ste > 0) {
                    // 如果接单，就开始扣费
                    val delivery = deliveryService.getByOrderNo(event.partnerOrderCode)
                    val order = orderService.selectOrderByCode(event.partnerOrderCode)
                    val amount = delivery!!.deliveryFee + (delivery.deliveryTips ?: 0)
                    // 记录消费
                    // 某个店铺 达达 消费
                    shopChargeRecordService.recordConsume(order.corpId, 0, amount, ShopChargeRecordConsumeType_EleDelivery, "蜂鸟配送费")
                }
                return if (ste > 0) "success" else "fail"
            }
            // 配送中
            EleOrderStatusOfDelivering -> {
                val ste = deliveryService.updateDeliveryOrderStatus(orderNo = event.partnerOrderCode, status = DeliveryService.StatusDeliverying)
                return if (ste > 0) "success" else "fail"
            }
            // 骑手已到店
            EleOrderStatusOfCarrierArrive -> {
                // 状态更改为 骑手已到店
                val ste = deliveryService.updateDeliveryOrderStatus(orderNo = event.partnerOrderCode, status = DeliveryService.StatusAtShop)
                return if (ste > 0) "success" else "fail"
            }
            // 系统已经分配送单
            EleOrderStatusOfAssignedCarrier -> {
                // 状态城改为待接单
                val ste = deliveryService.acceptOrder(
                        orderNo = event.partnerOrderCode,
                        carrierTel = event.carrierDriverPhone!!,  carrierName = event.carrierDriverName!!, carrierNo = null
                )
                return if (ste > 0) "success" else "fail"
            }
            else -> {
                val ste = deliveryService.updateDeliveryOrderStatus(orderNo = event.partnerOrderCode, status = event.orderStatus)
                return if (ste > 0) "success" else "fail"
            }
        }
    }
}
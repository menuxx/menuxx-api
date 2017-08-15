package com.yingtaohuo.controller

import cn.imdada.*
import com.github.pagehelper.PageInfo
import com.mall.annotation.CurrentDiner
import com.mall.configure.page.Page
import com.mall.exception.NotFoundException
import com.mall.exception.NotSupportException
import com.mall.model.TCorp
import com.mall.service.ConfigService
import com.mall.utils.Constants
import com.mall.utils.Util
import com.yingtaohuo.mode.Delivery
import com.yingtaohuo.mode.DeliveryTransporter
import com.yingtaohuo.mode.PostResult
import com.yingtaohuo.service.TransportService
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/7
 * 微信: yin80871901
 */

@RestController
open class DeliveryController(
        val transportService: TransportService,
        val configService: ConfigService
) {

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

    // 给某个订单追加小费
    data class PostTips(@NotNull val orderNo: String, @NotNull val tips: Int)
    @PutMapping("/diners/CORP_ID/deliveries/tip")
    fun addTips(@CurrentDiner diner: TCorp, @Valid @RequestBody tips: PostTips) : PostResult {
        val corpConfig = Util.getConfigs(configService.selectMyConfigs(diner.id))
        // 如果配送渠道是 dada 1
        if (corpConfig[Constants.TransportChannel]?.equals(1) ?: false) {
            val shop = transportService.getDeliveryShopByShopId(diner.id)
            val totalTips = transportService.dadaAddTipsToTransport(tips.orderNo, shop, tips.tips)
            return PostResult(ret = totalTips, orderNo = tips.orderNo, errorCode = 0, errorMsg = "ok")
        } else {
            return PostResult(ret = "not support", orderNo = tips.orderNo, errorCode = 404, errorMsg = "暂时不支持该通道")
        }
    }

    /**
     * 获取订单
     */
    @Page
    @GetMapping("/diners/{dinerId}/deliveries")
    open fun getTransports(@PathVariable dinerId: Int,
                           @RequestParam status: ArrayList<Int>,
                           @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGENUM) pageNum : Int,
                           @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGESIZE) pageSize: Int
    ) : PageInfo<Delivery>  = transportService.getShopTransportsFilterByStatus(dinerId, status)

    /**
     * 发送一个配送请求
     */
    data class PostDelivery(val orderNo: String)
    @PostMapping("/diners/{dinerId}/deliveries")
    fun resendTransport(@PathVariable dinerId: Int, @Valid @RequestBody delivery: PostDelivery) : PostResult {
        try {
            val fee = transportService.dadaOrderResend(delivery.orderNo)
            return PostResult(ret = fee, orderNo = delivery.orderNo, errorCode = 0, errorMsg = "ok")
        } catch (ex: ImDadaException) {
            return PostResult(ret = 0, orderNo = delivery.orderNo, errorCode = 1501, errorMsg = ex.message)
        }
    }

    @GetMapping("/diners/{dinerId}/deliveries/{did}/transporter")
    fun getTransporter(@CurrentDiner diner: TCorp, @PathVariable("did") deliveryId: Int) : DeliveryTransporter {
        val corpConfig = Util.getConfigs(configService.selectMyConfigs(diner.id))
        // 如果配送渠道是 dada 1
        if (corpConfig[Constants.TransportChannel]?.equals(1) ?: false) {
            val shop = transportService.getDeliveryShopByShopId(diner.id)
            val transport = transportService.getDeliveryById(deliveryId)
            if ( transport != null ) {
                return transportService.dadaTransportQuery(transport.orderNo, shop)
            } else {
                throw NotFoundException("不存在 id 为$deliveryId 的配送记录")
            }
        } else {
            throw NotSupportException("未选择或选择了未知的配送渠道")
        }
    }

}
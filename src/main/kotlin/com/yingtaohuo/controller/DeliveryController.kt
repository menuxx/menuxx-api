package com.yingtaohuo.controller

import cn.imdada.*
import com.github.pagehelper.PageInfo
import com.mall.AllOpen
import com.mall.annotation.CurrentDiner
import com.mall.configure.page.Page
import com.mall.exception.NotFoundException
import com.mall.exception.NotSupportException
import com.mall.model.TCorp
import com.mall.service.ConfigService
import com.mall.service.OrderService
import com.mall.utils.Constants
import com.mall.utils.Util
import com.yingtaohuo.mode.Delivery
import com.yingtaohuo.mode.DeliveryTransporter
import com.yingtaohuo.mode.PostResult
import com.yingtaohuo.service.DeliveryService
import com.yingtaohuo.service.ShopConfigService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/7
 * 微信: yin80871901
 */

@AllOpen
@RestController
@RequestMapping("/diners/{dinerId}")
class DeliveryController @Autowired constructor (
        private var deliveryService: DeliveryService,
        private var configService: ConfigService,
        private var orderService: OrderService,
        private var shopConfigService: ShopConfigService
) {

    private val logger = LoggerFactory.getLogger(DeliveryController::class.java)

    // 给某个订单追加小费
    data class PostTips(@NotNull val orderNo: String, @NotNull val tips: Int)
    @PutMapping("/deliveries/tip")
    fun addTips(@CurrentDiner diner: TCorp, @Valid @RequestBody tips: PostTips) : PostResult {
        val corpConfig = Util.getConfigs(configService.selectMyConfigs(diner.id))
        // 如果配送渠道是 dada 1
        if (corpConfig[Constants.TransportChannel]?.equals(1) == true) {
            val shop = deliveryService.getDeliveryMerchantByShopId(diner.id)
            val totalTips = deliveryService.dadaAddTipsToTransport(tips.orderNo, shop, tips.tips)
            return PostResult(ret = totalTips, orderNo = tips.orderNo, errorCode = 0, errorMsg = "ok")
        } else {
            return PostResult(ret = "not support", orderNo = tips.orderNo, errorCode = 404, errorMsg = "暂时不支持该通道")
        }
    }

    /**
     * 获取订单
     */
    @Page
    @GetMapping("/deliveries")
    fun getTransports(@PathVariable dinerId: Int,
                           @RequestParam status: ArrayList<Int>,
                           @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGENUM) pageNum : Int,
                           @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGESIZE) pageSize: Int
    ) : PageInfo<Delivery>  = deliveryService.getShopOrdersFilterByStatus(dinerId, status)

    /**
     * 发送一个配送请求
     */
    data class PostDelivery(val orderNo: String)
    @PostMapping("/deliveries")
    fun resendDelivery(@PathVariable dinerId: Int, @Valid @RequestBody delivery: PostDelivery) : PostResult {
        return try {
            val fee = deliveryService.dadaOrderResend(delivery.orderNo)
            PostResult(ret = fee, orderNo = delivery.orderNo, errorCode = 0, errorMsg = "ok")
        } catch (ex: ImDadaException) {
            PostResult(ret = 0, orderNo = delivery.orderNo, errorCode = 1501, errorMsg = ex.message)
        }
    }

    @GetMapping("/deliveries/{did}/transporter", "/deliveries/{did}/carrier")
    fun getTransporter(@PathVariable dinerId: Int, @PathVariable("did") deliveryId: Int) : DeliveryTransporter {
        val corpConfig = configService.selectConfig(dinerId)
        // 如果配送渠道是 dada 1
        if (corpConfig.deliveryChannel == 1) {
            val merchant = deliveryService.getDeliveryMerchantByShopId(dinerId)
            val transport = deliveryService.getDeliveryById(deliveryId)
            if ( transport != null ) {
                return deliveryService.dadaDeliveryQuery(transport.orderNo, merchant)
            } else {
                throw NotFoundException("不存在 id 为$deliveryId 的配送记录")
            }
        } else {
            throw NotSupportException("未选择或选择了未知的配送渠道")
        }
    }

    @GetMapping("/deliveries/cancel/reasons")
    fun getCancelReasons(@PathVariable dinerId: Int) = deliveryService.getCancelReasons(dinerId)

    data class OrderToChannel(val orderId: Int, val channelType: Int)
    // 配送订单到达大
    @PostMapping("/deliveries/transport_order", "/deliveries/delivery_order")
    fun deliveryToChannel(@PathVariable dinerId: Int, @RequestBody channel: OrderToChannel) : PostResult {
        return try {
            val order = orderService.selectOrder(channel.orderId)
            // 更新订单配送状态
            orderService.updateOrderTransportStatus(channel.orderId, 1)
            val isOk = deliveryService.deliveryOrderToChannel(order, channel.channelType)
            return if (isOk > 0) {
                PostResult(ret = isOk, orderNo = order.orderCode, errorCode = 0, errorMsg = "ok")
            } else {
                PostResult(ret = -1, orderNo = order.orderCode, errorCode = 1505, errorMsg = "订单传送失败")
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            PostResult(ret = -1, orderNo = "", errorCode = 1505, errorMsg = "订单传送失败")
        }
    }

    @PutMapping("/deliveries/{did}/cancel")
    fun cancelDelivery(@PathVariable dinerId: Int, @PathVariable("did") deliveryId: Int, @RequestBody reason: DDCancelReason) : PostResult {
        val delivery = deliveryService.getDeliveryById(deliveryId)
        val (_, isOk, message) = deliveryService.cancelDelivery(dinerId, delivery!!.orderNo, reason.id, reason.reason)
        return if ( isOk!! ) {
            PostResult(ret = 0, orderNo = delivery.orderNo, errorCode = 0, errorMsg = "ok")
        } else {
            PostResult(ret = 0, orderNo = delivery.orderNo, errorCode = 1503, errorMsg = message)
        }
    }

}
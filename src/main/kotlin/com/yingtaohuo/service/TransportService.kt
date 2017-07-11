package com.yingtaohuo.service

import cn.imdada.DDOrder
import cn.imdada.ImDadaApi
import cn.imdada.ImDadaException
import com.mall.service.AddressService
import com.mall.mapper.TTakeawayTransportMapper
import com.mall.model.TOrder
import com.mall.model.TTakeawayShop
import com.mall.model.TTakeawayTransport
import com.mall.model.TTakeawayTransportExample
import com.mall.service.OrderItemService
import com.yingtaohuo.props.ImDadaProperties
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/9
 * 微信: yin80871901
 */

@Service
open class TransportService(
        val takeawayTransportMapper: TTakeawayTransportMapper,
        val addressService: AddressService,
        val orderItemService: OrderItemService,
        val imdadaApi: ImDadaApi,
        val dadaMerchantService: DadaMerchantService,
        val imDadaProperties: ImDadaProperties
) {

    companion object {
        const val ChannelTypeOfImDada = 1
        const val ChannelTypeOfEle = 2

        // 订单配送状态	订单状态(待接单＝1 待取货＝2 配送中＝3 已完成＝4 已取消＝5 已过期＝7 指派单=8 系统故障订单发布失败=1000 可参考文末的状态说明)
        const val StatusWaitForAccept = 1 // 待接单 ＝ 1
        const val StatusWaitForFetch = 2  // 待取货 ＝ 2
        const val StatusTransport = 3     // 配送中 ＝ 3
        const val StatusFinish = 4        // 已完成 = 4
        const val StatusCancel = 5        // 订单已取消 = 5
        const val StatusExpired = 6       // 订单已过期 = 6
    }

    // 订单发送到 达达 的 配送渠道
    @Throws(ImDadaException::class)
    fun sendImdadaOrderTransportChannel(order: TOrder, shop: TTakeawayShop, takeoutFee: Double) : Int {

        val receiverAddress = addressService.selectAddress(order.addressId)

        val orderItems = orderItemService.selectOrderItemByOrderId(order.id)

        val merchant = dadaMerchantService.getById(shop.dadaMerchantId)

        val goodsCount = orderItems.size

        val goodsWeight = goodsCount * 0.2  // 按每件 0.2 千克计算

        val requireReceiveTime = (System.currentTimeMillis() / 1000) + (35 * 60)  // 希望35分钟内完成

        val ddOrder = DDOrder(
                shopNo = shop.shopNo,
                originId = order.orderCode,
                cityCode = shop.dadaCityCode,
                cargoPrice = (order.totalAmount / 100) * 1.0,                           // 单位分转换成单位元
                isPrepay = 0,                                                           // 不垫付
                expectedFetchTime = (System.currentTimeMillis() / 1000) + (5 * 60),     // 5 分钟后接单
                receiverName = receiverAddress.linkman,
                receiverAddress = receiverAddress.address,
                receiverPhone = receiverAddress.phone,
                receiverLng = receiverAddress.lng.toDouble(),
                receiverLat = receiverAddress.lat.toDouble(),
                callback = "${imDadaProperties.callbackUrl}?event_form=newdada",   // 事件回调地址
                tips = 0.0,
                payForSupplierFee = takeoutFee,    // 每单商家铺贴配送费
                fetchFromReceiverFee = 0.0,
                deliverFee = 0.0,
                createTime = (System.currentTimeMillis() / 1000),
                info = order.remark,
                cargoType = shop.shopType,
                cargoWeight = goodsWeight,
                cargoNum = goodsCount,
                expectedFinishTime = requireReceiveTime,
                invoiceTitle = null,
                deliverLockerCode = null,
                pickupLockerCode = null,
                originMark = "YinTaoHuo",
                originMarkNo = "${shop.dinerId}"
        )

        val addRes = imdadaApi.addOrder(merchant.sourceId, ddOrder)

        return createTransport(order, shop, goodsCount, goodsWeight, requireReceiveTime, (addRes.fee * 100).toInt(), addRes.distance.toLong(), ChannelTypeOfImDada)


    }

    // 订单发送到 饿了么 的 配送渠道
    fun sendEleOrderTansportChannel() {

    }

    /**
     * 创建一条配送记录
     */
    fun createTransport(
            order: TOrder,
            shop: TTakeawayShop,
            goodsCount: Int,
            goodsWeight: Double,
            requireReceiveTime: Long,
            transportFee: Int,
            transportDistance: Long,
            transportChannel: Int) : Int {

        val receiverAddress = addressService.selectAddress(order.addressId)

        val ttt = TTakeawayTransport()

        ttt.createTime = Date()
        ttt.status = StatusWaitForAccept
        ttt.goodsCount = goodsCount

        // 统一使用火星坐标系
        ttt.receiverLat = receiverAddress.lat
        ttt.receiverLng = receiverAddress.lng

        ttt.receiverName = receiverAddress.linkman
        ttt.receiverAddress = receiverAddress.address
        ttt.receiverTel = receiverAddress.phone

        ttt.goodsCount = 4
        ttt.orderNo = order.orderCode

        ttt.orderRemark = order.remark

        ttt.transportChannel = transportChannel
        ttt.transportFee = transportFee
        ttt.transportDistance = transportDistance

        // 默认不开发票
        ttt.isInvoiced = 0
        ttt.orderTotalAmount = order.totalAmount

        ttt.orderWeight = goodsWeight

        // 需要送达时间（毫秒)
        ttt.requireReceiveTime = Timestamp(requireReceiveTime)

        ttt.shopId = shop.id

        takeawayTransportMapper.insertSelective(ttt)

        return ttt.id
    }

    // 接单
    fun acceptOrder(orderNo: String, transportTel: String, transportNo: String, transportName: String) : Int {
        val ex = TTakeawayTransportExample()
        ex.createCriteria().andOrderNoEqualTo(orderNo)
        val tt = TTakeawayTransport()
        tt.transportTel = transportTel
        tt.transportNo = transportNo
        tt.transportName = transportName
        tt.acceptTime = Date()  // 接单时间
        tt.status = StatusWaitForFetch
        return takeawayTransportMapper.updateByExampleSelective(tt, ex)
    }

    // 其他状态更新
    fun transportStatusUpdate(orderNo: String, status: Int): Int {
        val ex = TTakeawayTransportExample()
        ex.createCriteria().andOrderNoEqualTo(orderNo)
        val tt = TTakeawayTransport()
        tt.updateTime = Date()  // 接单时间
        tt.status = status
        return takeawayTransportMapper.updateByExampleSelective(tt, ex)
    }

    // 配送结束
    fun finishTransport(orderNo: String) : Int {
        val ex = TTakeawayTransportExample()
        ex.createCriteria().andOrderNoEqualTo(orderNo)
        val tt = TTakeawayTransport()
        tt.finishTime = Date()  // 接单时间
        tt.status = StatusFinish
        return takeawayTransportMapper.updateByExampleSelective(tt, ex)
    }

    // 配送取消
    fun transportCancel(orderNo: String, reason: String) : Int {
        val ex = TTakeawayTransportExample()
        ex.createCriteria().andOrderNoEqualTo(orderNo)
        val tt = TTakeawayTransport()
        tt.finishTime = Date()  // 接单时间
        tt.cancelReason = reason
        tt.status = StatusCancel
        return takeawayTransportMapper.updateByExampleSelective(tt, ex)
    }

}
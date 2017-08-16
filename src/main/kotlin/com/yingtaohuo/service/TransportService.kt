package com.yingtaohuo.service

import cn.imdada.DDOrder
import cn.imdada.ImDadaApi
import cn.imdada.ImDadaException
import com.github.pagehelper.PageInfo
import com.mall.exception.NotFoundException
import com.mall.mapper.TDeliveryShopMapper
import com.mall.mapper.TDeliveryTransportMapper
import com.mall.service.AddressService
import com.mall.model.*
import com.mall.service.ItemService
import com.mall.service.OrderItemService
import com.mall.service.OrderService
import com.mall.utils.Util
import com.mall.wrapper.OrderWrapper
import com.yingtaohuo.mode.Delivery
import com.yingtaohuo.mode.DeliveryTransporter
import com.yingtaohuo.props.ImDadaProperties
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/9
 * 微信: yin80871901
 */

@Service
open class TransportService(
        private val deliveryTransportMapper: TDeliveryTransportMapper,
        private val deliveryShopMapper: TDeliveryShopMapper,
        private val addressService: AddressService,
        private val orderService: OrderService,
        private val orderWrapper: OrderWrapper,
        private val orderItemService: OrderItemService,
        private val itemService: ItemService,
        private val imdadaApi: ImDadaApi,
        private val dadaMerchantService: DadaMerchantService,
        private val imDadaProperties: ImDadaProperties
) {

    val dateFormat = SimpleDateFormat.getDateInstance()

    val logger = LoggerFactory.getLogger(TransportService::class.java)

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

    fun getTransportByOrderNo(orderNo: String) : TDeliveryTransport? {
        val ex = TDeliveryTransportExample()
        ex.createCriteria().andOrderNoEqualTo(orderNo)
        return Util.onlyOne(deliveryTransportMapper.selectByExample(ex))
    }

    fun getDeliveryShopByShopId(shopId: Int) : TDeliveryShop {
        val ex = TDeliveryShopExample()
        ex.createCriteria().andShopIdEqualTo(shopId)
        return Util.onlyOne<TDeliveryShop>(deliveryShopMapper.selectByExample(ex))
    }


    fun getMerchantByShopId(shopId: Int) : TDadaMerchant {
        val merchantId = deliveryShopMapper.selectByPrimaryKey(shopId).dadaMerchantId
        return dadaMerchantService.getById(merchantId)
    }

    private fun getGoodsRemark(orderItems: List<TOrderItem>, itemMap: Map<Int, TItem>) : String {
        return orderItems.map { item -> "${itemMap[item.itemId]?.itemName}${item.quantity}x份" } .joinToString { "," }
    }

    fun getImdadaOrder(order: TOrder, shop: TDeliveryShop, takeoutFee: Int, goodsCount: Int, goodsRemark: String, goodsWeight: Double, requireReceiveTime: Long) : DDOrder {
        val receiverAddress = addressService.selectAddress(order.addressId)
        return DDOrder(
                shopNo = shop.shopNo,
                originId = order.orderCode,
                cityCode = shop.dadaCityCode,
                cargoPrice = (order.totalAmount / 100) * 1.0,                           // 单位分转换成单位元
                isPrepay = 0,                                                           // 不垫付
                expectedFetchTime = (System.currentTimeMillis() / 1000) + (5 * 60),     // 5 分钟后接单
                receiverName = receiverAddress.linkman,
                receiverAddress = receiverAddress.address,
                receiverPhone = receiverAddress.phone,
                // receiverLng = receiverAddress.lng.toDouble(),
                // receiverLat = receiverAddress.lat.toDouble(),
                receiverLng = 120.096124,
                receiverLat = 30.280788,
                callback = "${imDadaProperties.callbackUrl}?event_form=newdada",   // 事件回调地址
                tips = 0.0,
                payForSupplierFee = (takeoutFee / 100).toDouble(),    // 每单商家铺贴配送费
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
                originMark = "YTH",
                originMarkNo = "${shop.shopId}${order.orderCode.substring(order.orderCode.length - 4)}"
        )
    }

    // 订单发送到 达达 的 配送渠道
    @Throws(ImDadaException::class)
    fun sendImdadaOrderTransportChannel(order: TOrder, shop: TDeliveryShop, takeoutFee: Int) : Int {

        val merchant = dadaMerchantService.getById(shop.dadaMerchantId)

        val orderItems = orderItemService.selectOrderItemByOrderId(order.id)

        val itemMap = itemService.selectItemsForMap(orderItems.map { it.id }.toList())

        val goodsRemark = getGoodsRemark(orderItems, itemMap)

        val goodsCount = orderItems.size

        val requireReceiveTime = (System.currentTimeMillis() / 1000) + (35 * 60)  // 希望35分钟内完成

        val goodsWeight = goodsCount * 0.2  // 按每件 0.2 千克计算

        val ddOrder = getImdadaOrder(order, shop, takeoutFee, goodsCount, goodsRemark, goodsWeight, requireReceiveTime)

        val addRes = imdadaApi.addOrder(merchant.sourceId, ddOrder)

        return createTransport(order, shop, goodsCount, goodsRemark, goodsWeight, requireReceiveTime, (addRes.fee * 100).toInt(), addRes.distance.toLong(), ChannelTypeOfImDada)
    }

    // 订单发送到 饿了么 的 配送渠道
    fun sendEleOrderTansportChannel() {

    }

    fun updateTransport(tid: Int, distance: Long, fee: Int) {
        val ttt = TDeliveryTransport()
        ttt.id = tid
        ttt.transportDistance = distance
        ttt.transportFee = fee
        ttt.resendTime = Date()
        deliveryTransportMapper.updateByPrimaryKeySelective(ttt)
    }

    /**
     * 创建一条配送记录
     */
    fun createTransport(
            order: TOrder,
            shop: TDeliveryShop,
            goodsCount: Int,
            goodsRemark: String,
            goodsWeight: Double,
            requireReceiveTime: Long,
            transportFee: Int,
            transportDistance: Long,
            transportChannel: Int) : Int {

        val receiverAddress = addressService.selectAddress(order.addressId)

        val ttt = TDeliveryTransport()

        ttt.createTime = Date()
        ttt.status = StatusWaitForAccept
        ttt.goodsCount = goodsCount
        ttt.goodsRemark = goodsRemark

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

        ttt.shopId = shop.shopId

        deliveryTransportMapper.insertSelective(ttt)

        return ttt.id
    }

    // 接单
    fun acceptOrder(orderNo: String, transportTel: String, transportNo: String, transportName: String) : Int {
        val ex = TDeliveryTransportExample()
        ex.createCriteria().andOrderNoEqualTo(orderNo)
        val tt = TDeliveryTransport()
        tt.transporterTel = transportTel
        tt.transporterNo = transportNo
        tt.transporterName = transportName
        tt.acceptTime = Date()  // 接单时间
        tt.status = StatusWaitForFetch

        return deliveryTransportMapper.updateByExampleSelective(tt, ex)
    }

    // 其他状态更新
    fun transportStatusUpdate(orderNo: String, status: Int): Int {
        val ex = TDeliveryTransportExample()
        ex.createCriteria().andOrderNoEqualTo(orderNo)
        val tt = TDeliveryTransport()
        tt.updateTime = Date()  // 接单时间
        tt.status = status
        return deliveryTransportMapper.updateByExampleSelective(tt, ex)
    }

    // 配送结束
    fun finishTransport(orderNo: String) : Int {
        val ex = TDeliveryTransportExample()
        ex.createCriteria().andOrderNoEqualTo(orderNo)
        val tt = TDeliveryTransport()
        tt.finishTime = Date()  // 接单时间
        tt.status = StatusFinish
        return deliveryTransportMapper.updateByExampleSelective(tt, ex)
    }

    // 配送取消
    fun transportCancel(orderNo: String, reason: String) : Int {
        val ex = TDeliveryTransportExample()
        ex.createCriteria().andOrderNoEqualTo(orderNo)
        val tt = TDeliveryTransport()
        tt.finishTime = Date()  // 接单时间
        tt.cancelReason = reason
        tt.status = StatusCancel
        return deliveryTransportMapper.updateByExampleSelective(tt, ex)
    }

    // 获取店铺的配送信息
    fun getShopTransportsFilterByStatus(shopId: Int, status: ArrayList<Int>) : PageInfo<Delivery> {

        val ttEx = TDeliveryTransportExample()
        ttEx.createCriteria().andShopIdEqualTo(shopId).andStatusIn(status)
        ttEx.orderByClause = "create_time desc"

        val dPage = PageInfo(deliveryTransportMapper.selectByExample(ttEx))

        val list = deliveryTransportMapper.selectByExample(ttEx)

        val shop = getDeliveryShopByShopId(shopId)

        val aPage = PageInfo(list.map { transport ->

            val order = orderWrapper.selectOrder(orderService.selectOrderByCode(transport.orderNo).id)

            Delivery(
                    transportId = transport.id,

                    orderNo = transport.orderNo,
                    orderTotalAmount = transport.orderTotalAmount,
                    transportChannel = transport.transportChannel,

                    receiverAddress = transport.receiverAddress,
                    receiverName = transport.receiverName,
                    receiverLat = transport.receiverLat.toDouble(),
                    receiverLng = transport.receiverLng.toDouble(),
                    receiverTel = transport.receiverTel,

                    status = transport.status,
                    requireReceiveTime = transport.requireReceiveTime,
                    transportFee = transport.transportFee,
                    transportDistance = transport.transportDistance,
                    createTime = transport.createTime,
                    cancelReason = transport.cancelReason,
                    errorMsg = transport.errorMsg,

                    transportTips = transport.transportTips,

                    transporterName = transport.transporterName,
                    transporterTel = transport.transporterTel,
                    transporterLat = null,
                    transporterLng = null,
                    transporterNo = transport.transporterNo,

                    shopName = shop.shopName,
                    shopNo = shop.id,
                    shopLat = shop.lat.toDouble(),
                    shopLng = shop.lng.toDouble(),

                    acceptTime = transport.acceptTime,
                    finishTime = transport.finishTime,
                    cancelTime = transport.cancelTime,
                    fetchTime = transport.fetchTime,
                    expireTime = transport.expireTime,
                    orderItemNames = order.orderItemNames,
                    remark = order.remark ?: ""
            )
        })

        // 拷贝属性
        aPage.endRow = dPage.endRow
        aPage.firstPage = dPage.firstPage
        aPage.prePage = dPage.prePage
        aPage.isHasNextPage = dPage.isHasNextPage
        aPage.isHasPreviousPage = dPage.isHasPreviousPage
        aPage.isIsFirstPage = dPage.isIsFirstPage
        aPage.isIsLastPage = dPage.isIsLastPage
        aPage.lastPage = dPage.lastPage
        aPage.navigatePages = dPage.navigatePages
        aPage.navigatepageNums = dPage.navigatepageNums
        aPage.nextPage = dPage.nextPage
        aPage.orderBy = dPage.orderBy
        aPage.pageSize = dPage.pageSize
        aPage.startRow = dPage.startRow
        aPage.total = dPage.total
        aPage.pageNum = dPage.pageNum
        aPage.size = dPage.size
        aPage.pages = dPage.pages

        return aPage

    }

    @Throws(ImDadaException::class, NotFoundException::class)
    fun dadaTransportQuery(orderNo: String, shop: TDeliveryShop) : DeliveryTransporter {
        val dtp = getTransportByOrderNo(orderNo)
        if (dtp != null) {
            val merchant = dadaMerchantService.getById(shop.dadaMerchantId)
            val tp = imdadaApi.queryDetail(merchant.sourceId, orderNo)
            return DeliveryTransporter(
                    transporterNo = dtp.transporterNo,
                    transporterName = tp.transporterName,
                    transporterTel = tp.transporterPhone,
                    transporterLat = tp.transporterLat.toDouble(),
                    transporterLng = tp.transporterLng.toDouble(),
                    deliveryFee = (tp.deliveryFee * 100).toInt(),
                    tips = tp.tips.toInt(),
                    acceptTime = if (tp.acceptTime != null) dateFormat.parse(tp.acceptTime) else null,
                    finishTime = if (tp.finishTime != null) dateFormat.parse(tp.finishTime) else null,
                    fetchTime = if (tp.fetchTime != null) dateFormat.parse(tp.fetchTime) else null,
                    cancelTime = if (tp.cancelTime != null) dateFormat.parse(tp.cancelTime) else null,
                    statusCode = tp.statusCode,
                    statusMsg = tp.statusMsg
            )
        }
        throw NotFoundException("delivery shop not found, orderNo: $orderNo")
    }

    @Throws(ImDadaException::class, NotFoundException::class)
    fun dadaOrderResend(orderNo: String) : Int {
        val order = orderService.selectOrderByCode(orderNo)
        val tp = getTransportByOrderNo(orderNo)
        if (tp != null) {
            val shop = deliveryShopMapper.selectByPrimaryKey(tp.shopId)
            val merchant = getMerchantByShopId(tp.shopId)
            val orderItems = orderItemService.selectOrderItemByOrderId(order.id)
            val itemMap = itemService.selectItemsForMap(orderItems.map { it.id }.toList())
            val goodsRemark = getGoodsRemark(orderItems, itemMap)
            val goodsCount = orderItems.size
            val requireReceiveTime = (System.currentTimeMillis() / 1000) + (35 * 60)  // 希望35分钟内完成
            val goodsWeight = goodsCount * 0.2  // 按每件 0.2 千克计算
            val ddOrder = getImdadaOrder(order, shop, tp.transportFee, goodsCount, goodsRemark, goodsWeight, requireReceiveTime)
            val resendRes = imdadaApi.reAddOrder(merchant.sourceId, ddOrder)
            updateTransport(tp.id, resendRes.distance.toLong(), (resendRes.fee * 100).toInt())
            return (resendRes.fee * 100).toInt()
        }
        throw NotFoundException("delivery shop not found, orderNo: $orderNo")
    }

    @Throws(ImDadaException::class, NotFoundException::class)
    fun dadaAddTipsToTransport(orderNo: String, shop: TDeliveryShop, tips: Int) : Int {
        val t1 = getTransportByOrderNo(orderNo)
        if (t1 != null) {
            val merchant = dadaMerchantService.getById(shop.dadaMerchantId)
            try {
                imdadaApi.addTips(merchant.sourceId, orderNo, (tips * 100).toFloat(), shop.dadaCityCode, "加钱快送")
                t1.transportTips += tips
                deliveryTransportMapper.updateByPrimaryKeySelective(t1)
                return t1.transportTips
            } catch (ex: ImDadaException) {
                logger.error("imdada add tips error: ", ex)
                throw ex
            }
        }
        throw NotFoundException("delivery shop not found, orderNo: $orderNo")
    }

    fun getDeliveryById(deliveryId: Int) : TDeliveryTransport? {
        return deliveryTransportMapper.selectByPrimaryKey(deliveryId)
    }

}
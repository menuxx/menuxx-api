package com.yingtaohuo.service

import cn.imdada.*
import com.github.pagehelper.PageInfo
import com.mall.AllOpen
import com.mall.exception.NotFoundException
import com.mall.mapper.TDeliveryMerchantMapper
import com.mall.mapper.TDeliveryOrderMapper
import com.mall.service.AddressService
import com.mall.model.*
import com.mall.service.ItemService
import com.mall.service.OrderItemService
import com.mall.service.OrderService
import com.mall.utils.Util
import com.mall.wrapper.OrderWrapper
import com.yingtaohuo.mode.Delivery
import com.yingtaohuo.mode.DeliveryTransporter
import com.yingtaohuo.mode.Result
import com.yingtaohuo.props.DeliveryPlatformProperties
import me.ele.delivery.*
import org.apache.commons.lang3.StringUtils
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/9
 * 微信: yin80871901
 */
@AllOpen
@Service
class DeliveryService(
        private val deliveryShopService: DeliveryShopService,
        private val deliveryOrderMapper: TDeliveryOrderMapper,
        private val deliveryMerchantMapper: TDeliveryMerchantMapper,
        private val shopChargeRecordService: ShopChargeRecordService,
        private val addressService: AddressService,
        private val orderService: OrderService,
        private val orderWrapper: OrderWrapper,
        private val orderItemService: OrderItemService,
        private val itemService: ItemService,
        private val imdadaApi: ImDadaApi,
        private val eleApi: EleApis,
        private val configService: ShopConfigService,
        private val dadaMerchantService: DadaMerchantService,
        private val deliveryProps: DeliveryPlatformProperties
) {

    private val dateFormat = SimpleDateFormat.getDateInstance()

    private val logger = LoggerFactory.getLogger(DeliveryService::class.java)

    companion object {
        const val ChannelTypeOfImDada = 1
        const val ChannelTypeOfEle = 2

        // 订单配送状态	订单状态(待接单＝1 待取货＝2 配送中＝3 已完成＝4 已取消＝5 已过期＝7 指派单=8 系统故障订单发布失败=1000 可参考文末的状态说明)
        const val StatusWaitForAccept = 1 // 待接单 ＝ 1
        const val StatusWaitForFetch = 2  // 待取货 ＝ 2
        const val StatusDeliverying = 3   // 配送中 ＝ 3
        const val StatusFinish = 4        // 已完成 = 4
        const val StatusCancel = 5        // 订单已取消 = 5
        const val StatusExpired = 6       // 订单已过期 = 6
        const val StatusAtShop = 7       // 骑手已到店 = 7
    }

    fun getByOrderNo(orderNo: String) : TDeliveryOrder? {
        val ex = TDeliveryOrderExample()
        ex.createCriteria().andOrderNoEqualTo(orderNo)
        return Util.onlyOne(deliveryOrderMapper.selectByExample(ex))
    }

    fun getDeliveryMerchantByShopId(shopId: Int) : TDeliveryMerchant {
        val ex = TDeliveryMerchantExample()
        ex.createCriteria().andShopIdEqualTo(shopId)
        return Util.onlyOne<TDeliveryMerchant>(deliveryMerchantMapper.selectByExample(ex))
    }

    fun getMerchantByShopId(shopId: Int) : TDadaMerchant {
        val ex = TDeliveryMerchantExample()
        ex.createCriteria().andShopIdEqualTo(shopId)
        val shop =  Util.onlyOne(deliveryMerchantMapper.selectByExample(ex))
        return dadaMerchantService.getById(shop.dadaMerchantId)
    }

    private fun getGoodsRemark(orderItems: List<TOrderItem>, itemMap: Map<Int, TItem>) : String {
        return orderItems.joinToString(",") { item -> "${itemMap[item.itemId]?.itemName}${item.quantity}x份" }
    }

    fun getEleOrder(order: TOrder, shop: TDeliveryMerchant, items: List<EleItem>, goodsCount: Int, goodsWeight: Float) : ElePostOrder {
        val receiverAddress = addressService.selectAddress(order.addressId)
        return ElePostOrder(
                partnerRemark = shop.shopName,
                partnerOrderCode = order.orderCode,
                notifyUrl =  "${deliveryProps.ele!!.callbackUrl}?event=ele_push_order",
                orderType = 1,  // 蜂鸟配送
                transportInfo = EleTransportInfo(
                        transportName = shop.shopName,
                        transportAddress = shop.shopAddress,
                        transportLongitude = shop.lng.toDouble(),
                        transportLatitude = shop.lat.toDouble(),
                        positionSource = 3,
                        transportTel = shop.contactPhone,
                        transportRemark = "店主联系方式：" + shop.contactName + ", " + shop.contactPhone
                ),
                transportRemark = "店主联系方式：" + shop.contactName + ", " + shop.contactPhone,
                orderAddTime = null,
                orderTotalAmount = (order.totalAmount / 100).toFloat(),
                orderActualAmount = (order.payAmount / 100).toFloat(),
                orderWeight = goodsWeight,
                orderRemark = order.remark + "",
                isInvoiced = 0,
                orderPaymentStatus = 1, // 订单支付状态已支付
                orderPaymentMethod = 1,
                isAgentPayment = 0, // 不需要代收服务
                receiverInfo = EleReceiverInfo(
                        receiverName = receiverAddress.linkman,
                        receiverPrimaryPhone = receiverAddress.phone,
                        receiverSecondPhone = null,
                        receiverAddress = receiverAddress.address,
                        receiverLongitude = receiverAddress.lng.toDouble(),
                        receiverLatitude = receiverAddress.lat.toDouble(),
                        positionSource = 3
                ),
                requirePaymentPay = null,
                goodsCount = goodsCount,
                itemsJson = items,
                requireReceiveTime = LocalDateTime.now().plusMinutes(5L).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(),
                serialNumber = order.orderCode.substring(order.orderCode.length - 6)
        )
    }

    fun getImdadaOrder(order: TOrder, shop: TDeliveryMerchant, deliveryFee: Int, goodsCount: Int, goodsRemark: String, goodsWeight: Double, requireReceiveTime: Long) : DDOrder {
        val receiverAddress = addressService.selectAddress(order.addressId)
        return DDOrder(
                shopNo = shop.shopNo,
                originId = order.orderCode,
                cityCode = shop.dadaCityCode,
                cargoPrice = (order.totalAmount / 100) * 1.0,                           // 单位分转换成单位元
                isPrepay = 0,                                                           // 不垫付
                expectedFetchTime = requireReceiveTime,     // 5 分钟后接单
                receiverName = receiverAddress.linkman,
                receiverAddress = receiverAddress.address,
                receiverPhone = receiverAddress.phone,
                receiverLng = receiverAddress.lng.toDouble(),
                receiverLat = receiverAddress.lat.toDouble(),
                //receiverLng = 120.096124,
                //receiverLat = 30.280788,
                callback = "${deliveryProps.imdada!!.callbackUrl}?event_form=newdada",   // 事件回调地址
                tips = 0.0,
                payForSupplierFee = (deliveryFee / 100).toDouble(),    // 每单商家铺贴配送费
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
    fun sendImdadaOrderDeliveryChannel(order: TOrder, shop: TDeliveryMerchant, deliveryFee: Int) : Int {

        val merchant = dadaMerchantService.getById(shop.dadaMerchantId)

        val orderItems = orderItemService.selectOrderItemByOrderId(order.id)

        val itemMap = itemService.selectItemsForMap(orderItems.map { it.itemId }.toList())

        val goodsRemark = getGoodsRemark(orderItems, itemMap)

        val goodsCount = orderItems.size

        val requireReceiveTime = (System.currentTimeMillis() / 1000)  // 希望5分钟内完成

        val goodsWeight = goodsCount * 0.1  // 按每件 0.2 千克计算

        val ddOrder = getImdadaOrder(order, shop, deliveryFee, goodsCount, goodsRemark, goodsWeight, requireReceiveTime)

        val addRes = imdadaApi.addOrder(merchant.sourceId, ddOrder)

        return createOrder(order, shop.shopId, goodsCount, goodsRemark, goodsWeight, requireReceiveTime, (addRes.fee * 100).toInt(), addRes.distance.toLong(), ChannelTypeOfImDada)
    }

    // 订单发送到 蜂鸟 的 配送渠道
    @Throws(EleException::class)
    fun sendEleOrderDeliveryChannel(order: TOrder, shop: TDeliveryMerchant) : Int {

        val orderItems = orderItemService.selectOrderItemByOrderId(order.id)

        val itemMap = itemService.selectItemsForMap(orderItems.map { it.itemId }.toList())

        val goodsRemark = getGoodsRemark(orderItems, itemMap)

        val goodsCount = orderItems.size

        val requireReceiveTime = (System.currentTimeMillis() / 1000)  // 希望5分钟内完成

        val goodsWeight = goodsCount * 0.1  // 按每件 0.2 千克计算

        val items = orderItems.map { _item ->
            EleItem(
                    itemId = _item.itemId.toString(),
                    itemName = itemMap[_item.itemId]!!.itemName,
                    itemQuantity = _item.quantity,
                    itemPrice = (itemMap[_item.itemId]!!.productPrice / 100).toFloat(),
                    itemActualPrice = (_item.dealPrice / 100).toFloat(),
                    itemSize = null,
                    itemRemark = itemMap[_item.itemId]!!.itemDesc,
                    isNeedPackage = 0,
                    isAgentPurchase = 0,
                    agentPurchasePrice = null
            )
        }

        val postOrder = getEleOrder(order, shop, items, goodsCount, goodsWeight.toFloat())

        eleApi.postOrder(postOrder)

        return createOrder(order, shop.shopId, goodsCount, goodsRemark, goodsWeight, requireReceiveTime, 0, 0, ChannelTypeOfEle)
    }

    fun getCancelReasons(shopId: Int) : List<DDCancelReason> {
        val shop = deliveryShopService.getDeliveryShopByShopId(shopId)
        val merchant = dadaMerchantService.getById(shop.dadaMerchantId)
        return imdadaApi.getCancelReasons(merchant.sourceId)
    }

    fun updateOrder(tid: Int, distance: Long, fee: Int, status: Int=0) {
        val ttt = TDeliveryOrder()
        ttt.id = tid
        ttt.deliveryDistance = distance
        ttt.deliveryFee = fee
        ttt.resendTime = Date()
        if ( status > 0 ) {
            ttt.status = status
        }
        deliveryOrderMapper.updateByPrimaryKeySelective(ttt)
    }

    /**
     * 创建一条配送记录
     */
    fun createOrder(
            order: TOrder,
            shopId: Int,
            goodsCount: Int,
            goodsRemark: String,
            goodsWeight: Double,
            requireReceiveTime: Long,
            deliveryFee: Int,
            deliveryDistance: Long,
            transportChannel: Int) : Int {

        val receiverAddress = addressService.selectAddress(order.addressId)

        val ttt = TDeliveryOrder()

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

        ttt.goodsCount = goodsCount
        ttt.orderNo = order.orderCode

        ttt.orderRemark = order.remark

        ttt.deliveryChannel = transportChannel
        ttt.deliveryFee = deliveryFee
        ttt.deliveryDistance = deliveryDistance

        // 默认不开发票
        ttt.isInvoiced = 0
        ttt.orderTotalAmount = order.totalAmount

        ttt.orderWeight = goodsWeight

        // 需要送达时间（毫秒)
        ttt.requireReceiveTime = Timestamp(requireReceiveTime)

        ttt.shopId = shopId

        deliveryOrderMapper.insertSelective(ttt)

        return ttt.id
    }

    // 接单
    fun acceptOrder(orderNo: String, carrierTel: String, carrierName: String, carrierNo: String?) : Int {
        val ex = TDeliveryOrderExample()
        ex.createCriteria().andOrderNoEqualTo(orderNo)
        val tt = TDeliveryOrder()
        tt.carrierTel = carrierTel
        tt.carrierNo = carrierNo
        tt.carrierName = carrierName
        tt.acceptTime = Date()  // 接单时间
        tt.status = StatusWaitForFetch
        return deliveryOrderMapper.updateByExampleSelective(tt, ex)
    }

    // 其他状态更新
    fun updateDeliveryOrderStatus(orderNo: String, status: Int): Int {
        val ex = TDeliveryOrderExample()
        ex.createCriteria().andOrderNoEqualTo(orderNo)
        val tt = TDeliveryOrder()
        tt.updateTime = Date()  // 接单时间
        tt.status = status
        return deliveryOrderMapper.updateByExampleSelective(tt, ex)
    }

    // 配送结束
    fun finishOrder(orderNo: String) : Int {
        val ex = TDeliveryOrderExample()
        ex.createCriteria().andOrderNoEqualTo(orderNo)
        val tt = TDeliveryOrder()
        tt.finishTime = Date()  // 接单时间
        tt.status = StatusFinish
        return deliveryOrderMapper.updateByExampleSelective(tt, ex)
    }

    // 配送取消
    fun orderCancel(orderNo: String, reason: String) : Int {
        val ex = TDeliveryOrderExample()
        ex.createCriteria().andOrderNoEqualTo(orderNo)
        val tt = TDeliveryOrder()
        tt.finishTime = Date()  // 接单时间
        tt.cancelReason = reason
        tt.status = StatusCancel
        return deliveryOrderMapper.updateByExampleSelective(tt, ex)
    }

    // 获取店铺的配送信息
    fun getShopOrdersFilterByStatus(shopId: Int, status: ArrayList<Int>) : PageInfo<Delivery> {

        val ttEx = TDeliveryOrderExample()
        ttEx.createCriteria()
                .andShopIdEqualTo(shopId)
                .andStatusIn(status)
                // 当前时间的过去 24 小时 的数据才显示
                .andUpdateTimeGreaterThan( Date(Date().time - (3600 * 24 * 1000)) )

        ttEx.orderByClause = "create_time desc"

        val dPage = PageInfo(deliveryOrderMapper.selectByExample(ttEx))

        val list = deliveryOrderMapper.selectByExample(ttEx)

        val shop = getDeliveryMerchantByShopId(shopId)

        val aPage = PageInfo(list.map { transport ->

            val order = orderWrapper.selectOrder(orderService.selectOrderByCode(transport.orderNo).id)

            Delivery(
                    transportId = transport.id,

                    orderNo = transport.orderNo,
                    orderTotalAmount = transport.orderTotalAmount,
                    transportChannel = transport.deliveryChannel,

                    receiverAddress = transport.receiverAddress,
                    receiverName = transport.receiverName,
                    receiverLat = transport.receiverLat.toDouble(),
                    receiverLng = transport.receiverLng.toDouble(),
                    receiverTel = transport.receiverTel,

                    status = transport.status,
                    requireReceiveTime = transport.requireReceiveTime,
                    transportFee = transport.deliveryFee,
                    transportDistance = transport.deliveryDistance,
                    createTime = transport.createTime,
                    cancelReason = transport.cancelReason,
                    errorMsg = transport.errorMsg,

                    transportTips = transport.deliveryTips,

                    transporterName = transport.carrierName,
                    transporterTel = transport.carrierTel,
                    transporterLat = null,
                    transporterLng = null,
                    transporterNo = transport.carrierNo,

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
    fun dadaDeliveryQuery(orderNo: String, shop: TDeliveryMerchant) : DeliveryTransporter {
        val dtp = getByOrderNo(orderNo)
        if (dtp != null) {
            val merchant = dadaMerchantService.getById(shop.dadaMerchantId)
            val tp = imdadaApi.queryDetail(merchant.sourceId, orderNo)
            return DeliveryTransporter(
                    transporterNo = dtp.carrierNo,
                    transporterName = tp.transporterName,
                    transporterTel = tp.transporterPhone,
                    transporterLat = tp.transporterLat.toDouble(),
                    transporterLng = tp.transporterLng.toDouble(),
                    deliveryFee = (tp.deliveryFee * 100).toInt(),
                    tips = tp.tips.toInt(),
                    acceptTime = if (!StringUtils.isBlank(tp.acceptTime)) dateFormat.parse(tp.acceptTime) else null,
                    finishTime = if (!StringUtils.isBlank(tp.finishTime)) dateFormat.parse(tp.finishTime) else null,
                    fetchTime = if (!StringUtils.isBlank(tp.fetchTime)) dateFormat.parse(tp.fetchTime) else null,
                    cancelTime = if (!StringUtils.isBlank(tp.cancelTime)) dateFormat.parse(tp.cancelTime) else null,
                    statusCode = tp.statusCode,
                    statusMsg = tp.statusMsg
            )
        }
        throw NotFoundException("delivery shop not found, orderNo: $orderNo")
    }

    @Throws(ImDadaException::class, NotFoundException::class)
    fun dadaOrderResend(orderNo: String) : Int {
        val order = orderService.selectOrderByCode(orderNo)
        val tp = getByOrderNo(orderNo)
        if (tp != null) {
            val shop = deliveryShopService.getDeliveryShopByShopId(tp.shopId)
            val merchant = getMerchantByShopId(tp.shopId)
            val orderItems = orderItemService.selectOrderItemByOrderId(order.id)
            val itemMap = itemService.selectItemsForMap(orderItems.map { it.id }.toList())
            val goodsRemark = getGoodsRemark(orderItems, itemMap)
            val goodsCount = orderItems.size
            val requireReceiveTime = (System.currentTimeMillis() / 1000) + (35 * 60)  // 希望35分钟内完成
            val goodsWeight = goodsCount * 0.2  // 按每件 0.2 千克计算
            val ddOrder = getImdadaOrder(order, shop, tp.deliveryFee, goodsCount, goodsRemark, goodsWeight, requireReceiveTime)
            val resendRes = imdadaApi.reAddOrder(merchant.sourceId, ddOrder)
            // 如果计算得到新的配送费 大于0 ，就代表发单成功
            val status = if (resendRes.fee > 0) 1 else 0
            updateOrder(tp.id, resendRes.distance.toLong(), (resendRes.fee * 100).toInt(), status)
            return (resendRes.fee * 100).toInt()
        }
        throw NotFoundException("delivery shop not found, orderNo: $orderNo")
    }

    @Throws(ImDadaException::class, NotFoundException::class)
    fun dadaAddTipsToTransport(orderNo: String, shop: TDeliveryMerchant, tips: Int) : Int {
        val t1 = getByOrderNo(orderNo)
        if (t1 != null) {
            val merchant = dadaMerchantService.getById(shop.dadaMerchantId)
            try {
                imdadaApi.addTips(merchant.sourceId, orderNo, (tips * 100).toFloat(), shop.dadaCityCode, "加钱快送")
                t1.deliveryTips += tips
                deliveryOrderMapper.updateByPrimaryKeySelective(t1)
                return t1.deliveryTips
            } catch (ex: ImDadaException) {
                logger.error("imdada add tips error: ", ex)
                throw ex
            }
        }
        throw NotFoundException("delivery shop not found, orderNo: $orderNo")
    }

    fun getDeliveryById(deliveryId: Int) : TDeliveryOrder? {
        return deliveryOrderMapper.selectByPrimaryKey(deliveryId)
    }


    fun cancelDelivery(shopId: Int, orderId: String, reasonId: Int, reason: String) : Result {
        val merchant = getMerchantByShopId(shopId)
        val formalCancel = DDFormalCancel(orderId = orderId, cancelReasonId = reasonId, cancelReason = reason)
        return try {
            val (deductFee) = imdadaApi.formalCancel(merchant.sourceId, formalCancel)
            // 记录违约金消耗
            shopChargeRecordService.recordConsume(shopId, 0, deductFee * 100, 3, "reasonId: $reasonId, reason: $reason")
            Result(deductFee,true, "正在取消")
        } catch (ex: ImDadaException) {
            Result(null, false, ex.message)
        }
    }

    fun deliveryOrderToChannel(order: TOrder, deliveryChannel: Int) : Int {
        // 当订单是外卖单，并且存在地址
        if (order.orderType == Order.ORDER_TYPE_DELIVERED && order.addressId != null)
        {
            // 配送渠道选用达达的时候
            if (deliveryChannel == DeliveryService.ChannelTypeOfImDada) {
                // 找到该订单绑定的配送店铺
                val shop = getDeliveryMerchantByShopId(order.corpId)
                val shopConf = configService.getShopConfig(order.corpId)
                return try {
                    // 目前配送费 统一按照4块来算
                    sendImdadaOrderDeliveryChannel(order, shop, shopConf.deliveryFee)
                } catch (e: ImDadaException) {
                    e.printStackTrace()
                    logger.error(e.message)
                    0
                }
            } else if ( deliveryChannel == DeliveryService.ChannelTypeOfEle ) {
                val shop = getDeliveryMerchantByShopId(order.corpId)
                return try {
                    sendEleOrderDeliveryChannel(order, shop)
                } catch (e: EleException) {
                    e.printStackTrace()
                    logger.error(e.message)
                    0
                }
            }
        }
        return 0
    }

}
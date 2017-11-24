package me.ele.delivery

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import kotlin.collections.ArrayList

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/3
 * 微信: yin80871901
 */

/**
 * 蜂鸟配送"系统已接单"状态返回JSON数据如下:
{
"open_order_code": "160103",
"partner_order_code": "BG658907200991",
"order_status": 1,
"push_time": 1466095163344,
"carrier_driver_name": "",
"carrier_driver_phone": "",
"description": "",
"error_code":""
}

订单"已分配骑手"状态返回JSON数据如下:
{
"open_order_code": "160103",
"partner_order_code": "BG658907200991",
"order_status": 20,
"push_time": 1466095163344,
"carrier_driver_name": "张三",
"carrier_driver_phone": "18602030493",
"description": "",
"station_name":"亦庄配送站",
"station_tel":"18602393333",
"error_code":""
}

订单"配送中"的状态返回JSON数据如下:

{
"open_order_code": "160093",
"partner_order_code": "BG659915200312",
"order_status": 2,
"push_time": 1466129638461,
"carrier_driver_name": "周智伟",
"carrier_driver_phone": "18501336429",
"description": "",
"error_code":""
}


订单"已取消"状态返回JSON数据如下:

{
"open_order_code": "160093",
"partner_order_code": "BG659915200312",
"order_status": 4,
"push_time": 1466132529983,
"carrier_driver_name": "周智伟",
"carrier_driver_phone": "18501336429",
"cancel_reason": 1,
"description": "",
"error_code":""
}

订单"系统拒单/配送异常"状态返回JSON数据如下:

{
"open_order_code": "160093",
"partner_order_code": "BG659915200312",
"order_status": 5,
"push_time": 1466132529983,
"carrier_driver_name": "",
"carrier_driver_phone": "",
"description": "订单重复",
"error_code":"ORDER_REPETITION"
}
 */

val EleOrderStatusOfFail = 5   // 系统拒单/配送异常
val EleOrderStatusOfArrive = 3 // 已送达
val EleOrderStatusOfDelivering = 2 // 配送中
val EleOrderStatusOfCarrierArrive = 80 // 骑手已到店
val EleOrderStatusOfAssignedCarrier = 20 // 已分配骑手
val EleOrderStatusOfAccept = 1 // 系统已接单

data class EleOrderEvent(
        // 蜂鸟配送开放平台返回的订单号
        @get:JsonProperty("open_order_code") @SerializedName("open_order_code") val openOrderCode: String,
        // 商户自己的订单号
        @get:JsonProperty("partner_order_code") @SerializedName("partner_order_code") val partnerOrderCode: String,
        // 状态码
        @get:JsonProperty("order_status") @SerializedName("order_status") val orderStatus: Int,
        // 状态推送时间(毫秒)
        @get:JsonProperty("push_time") @SerializedName("push_time") val pushTime: Long,
        // 蜂鸟配送员姓名
        @get:JsonProperty("carrier_driver_name") @SerializedName("carrier_driver_name") val carrierDriverName: String?,
        // 蜂鸟配送员电话
        @get:JsonProperty("carrier_driver_phone") @SerializedName("carrier_driver_phone") val carrierDriverPhone: String?,
        // 定点次日达服务独有的字段: 微仓地址
        @get:JsonProperty("address") @SerializedName("address") val address: String?,
        @get:JsonProperty("station_name") @SerializedName("station_name") val stationName: String?,
        @get:JsonProperty("station_tel") @SerializedName("station_tel") val stationTel: String?,
        // 定点次日达服务独有的字段: 微仓纬度
        @get:JsonProperty("latitude") @SerializedName("latitude") val latitude: Double?,
        // 定点次日达服务独有的字段: 微仓经度
        @get:JsonProperty("longitude") @SerializedName("longitude") val longitude: Double?,
        // 描述信息
        @get:JsonProperty("description") @SerializedName("description") val description: String?,
        // 错误编码
        @get:JsonProperty("error_code") @SerializedName("error_code") val errorCode: String?,
        // 订单取消原因. 1:用户取消, 2:商家取消
        @get:JsonProperty("cancel_reason") @SerializedName("cancel_reason") val cancelReason: String?
)

/**
 * partner_remark	string	255	否	商户备注信息
partner_order_code	string	128	是	商户订单号,要求唯一
notify_url	string	255	是	回调地址,订单状态变更时会调用此接口传递状态信息
order_type	int	-	是	订单类型 1: 蜂鸟配送，支持90分钟内送达
transport_name	string	64	是	门店名称
transport_address	string	255	是	取货点地址
transport_longitude	decimal	-	是	取货点经度，取值范围0～180
transport_latitude	decimal	-	是	取货点纬度，取值范围0～90
position_source	int	-	是	取货点经纬度来源, 1:腾讯地图, 2:百度地图, 3:高德地图
transport_tel	string	16	是	取货点联系方式, 只支持手机号,400开头电话以及座机号码
transport_remark	string	255	否	取货点备注
order_add_time	long	-	否	下单时间(毫秒)
order_total_amount	decimal	10	是	订单总金额（不包含商家的任何活动以及折扣的金额）
order_actual_amount	decimal	10	是	客户需要支付的金额
order_weight	decimal	11	否	订单总重量（kg），营业类型选定为果蔬生鲜、商店超市、其他三类时必填，大于0kg并且小于等于6kg
order_remark	string	255	否	用户备注
is_invoiced	int	-	是	是否需要发票, 0:不需要, 1:需要
invoice	string	128	否	发票抬头, 如果需要发票, 此项必填
order_payment_status	int	-	是	订单支付状态 0:未支付 1:已支付
order_payment_method	int	-	是	订单支付方式 1:在线支付
is_agent_payment	int	-	是	是否需要ele代收 0:否
require_payment_pay	decimal	-	否	需要代收时客户应付金额, 如果需要ele代收 此项必填
goods_count	int	-	是	订单货物件数
require_receive_time	long	-	否	需要送达时间（毫秒).
receiver_name	string	30	是	收货人姓名
receiver_primary_phone	string	64	是	收货人联系电话, 只支持手机号, 只支持手机号
receiver_second_phone	string	64	否	收货人备用联系电话
receiver_address	string	255	是	收货人地址
receiver_longitude	decimal	-	是	收货人经度，取值范围0～180
receiver_latitude	decimal	-	是	收货人纬度，取值范围0～90
position_source	int	-	是	收货人经纬度来源, 1:腾讯地图, 2:百度地图, 3:高德地图
item_id	string	-	否	商品编号
item_name	string	-	是	商品名称
item_quantity	int	-	是	商品数量
item_price	decimal	-	是	商品原价
item_actual_price	decimal	-	是	商品实际支付金额
item_size	int	-	否	商品尺寸
item_remark	string	-	否	商品备注
is_need_package	int	-	是	是否需要ele打包 0:否 1:是
is_agent_purchase	int	-	是	是否代购 0:否
agent_purchase_price	decimal	-	否	代购进价, 如果需要代购 此项必填
serial_number	string	6	否	商家订单流水号, 方便配送骑手到店取货, 支持数字,字母及#等常见字符. 如不填写, 蜂鸟将截取商家订单号后4位作为流水号.
 */

/**
 * 门店名称
 * example:
 * {
"transport_name": "XXX烤鸭店",
"transport_address": "上海市普陀区近铁城市广场5楼",
"transport_longitude": 120.00000,
"transport_latitude": 30.11111,
"position_source": 1,
"transport_tel": "13901232231",
"transport_remark": "备注"
}
 */

data class EleTransportInfo(
    // string	64	是	门店名称
        @get:JsonProperty("transport_name") @SerializedName("transport_name") val transportName: String,
    // string	255	是	取货点地址
        @get:JsonProperty("transport_address") @SerializedName("transport_address") val transportAddress: String,
    // decimal	-	是	取货点经度，取值范围0～180
        @get:JsonProperty("transport_longitude") @SerializedName("transport_longitude") val transportLongitude: Double,
    // decimal	-	是	取货点纬度，取值范围0～90
        @get:JsonProperty("transport_latitude") @SerializedName("transport_latitude") val transportLatitude: Double,
    // int	-	是	取货点经纬度来源, 1:腾讯地图, 2:百度地图, 3:高德地图
        @get:JsonProperty("position_source") @SerializedName("position_source") val positionSource: Int,
    // string	16	是	取货点联系方式, 只支持手机号,400开头电话以及座机号码
        @get:JsonProperty("transport_tel") @SerializedName("transport_tel") val transportTel: String,
    // string	255	否	取货点备注
        @get:JsonProperty("transport_remark") @SerializedName("transport_remark") val transportRemark: String?
)

/**
 *{
"receiver_name": "李明",
"receiver_primary_phone": "13900000000",
"receiver_second_phone": "13911111111",
"receiver_address": "上海市近铁广场",
"receiver_longitude": 130.0,
"receiver_latitude": 30.0,
"position_source": 1
}
 */

data class EleReceiverInfo(
        // string	30	是	收货人姓名
        @get:JsonProperty("receiver_name") @SerializedName("receiver_name") val receiverName: String,
        // string	64	是	收货人联系电话, 只支持手机号, 只支持手机号
        @get:JsonProperty("receiver_primary_phone") @SerializedName("receiver_primary_phone") val receiverPrimaryPhone: String?,
        // string	64	否	收货人备用联系电话
        @get:JsonProperty("receiver_second_phone") @SerializedName("receiver_second_phone") val receiverSecondPhone: String?,
        // 	string	255	是	收货人地址
        @get:JsonProperty("receiver_address") @SerializedName("receiver_address") val receiverAddress: String,
        // decimal	-	是	收货人经度，取值范围0～180
        @get:JsonProperty("receiver_longitude") @SerializedName("receiver_longitude") val receiverLongitude: Double,
        // decimal	-	是	收货人纬度，取值范围0～90
        @get:JsonProperty("receiver_latitude") @SerializedName("receiver_latitude") val receiverLatitude: Double,
        // int	-	是	收货人经纬度来源, 1:腾讯地图, 2:百度地图, 3:高德地图
        @get:JsonProperty("position_source") @SerializedName("position_source") val positionSource: Int
)

data class ElePostOrder(
        // string	255	否	商户备注信息
        @get:JsonProperty("partner_remark") @SerializedName("partner_remark") val partnerRemark: String?,
        // string	128	是	商户订单号,要求唯一
        @get:JsonProperty("partner_order_code") @SerializedName("partner_order_code") val partnerOrderCode: String,
        // string	255	是	回调地址,订单状态变更时会调用此接口传递状态信息
        @get:JsonProperty("notify_url") @SerializedName("notify_url") val notifyUrl: String,
        // int	-	是	订单类型 1: 蜂鸟配送，支持90分钟内送达
        @get:JsonProperty("order_type") @SerializedName("order_type") val orderType: Int,
        // EleTransportInfo - 是 门店信息
        @get:JsonProperty("transport_info") @SerializedName("transport_info") val transportInfo: EleTransportInfo,
        // 	string	255	否	取货点备注
        @get:JsonProperty("transport_remark") @SerializedName("transport_remark") val transportRemark: String,
        // 下单时间(毫秒)
        @get:JsonProperty("order_add_time") @SerializedName("order_add_time") val orderAddTime: Long?,
        // decimal	10	是	订单总金额（不包含商家的任何活动以及折扣的金额）
        @get:JsonProperty("order_total_amount") @SerializedName("order_total_amount") val orderTotalAmount: Float,
        // decimal	10	是	客户需要支付的金额
        @get:JsonProperty("order_actual_amount") @SerializedName("order_actual_amount") val orderActualAmount: Float,
        // 订单总重量（kg），营业类型选定为果蔬生鲜、商店超市、其他三类时必填，大于0kg并且小于等于6kg
        @get:JsonProperty("order_weight") @SerializedName("order_weight") val orderWeight: Float?,
        // 用户备注
        @get:JsonProperty("order_remark") @SerializedName("order_remark") val orderRemark: String?,
        // 是否需要发票, 0:不需要, 1:需要
        @get:JsonProperty("is_invoiced") @SerializedName("is_invoiced") val isInvoiced: Int,
        // 订单支付状态 0:未支付 1:已支付
        @get:JsonProperty("order_payment_status") @SerializedName("order_payment_status") val orderPaymentStatus: Int,
        // int	-	是	订单支付方式 1:在线支付
        @get:JsonProperty("order_payment_method") @SerializedName("order_payment_method") val orderPaymentMethod: Int,
        // int	-	是	是否需要ele代收 0:否
        @get:JsonProperty("is_agent_payment") @SerializedName("is_agent_payment") val isAgentPayment: Int,
        // EleReceiverInfo - 是 收货人信息
        @get:JsonProperty("receiver_info") @SerializedName("receiver_info") val receiverInfo: EleReceiverInfo,
        //decimal	-	否	需要代收时客户应付金额, 如果需要ele代收 此项必填
        @get:JsonProperty("require_payment_pay") @SerializedName("require_payment_pay") val requirePaymentPay: Float?,
        // goods_count	int	-	是	订单货物件数
        @get:JsonProperty("goods_count") @SerializedName("goods_count") val goodsCount: Int,
        // EleItem 是 配送商品信息
        @get:JsonProperty("items_json") @SerializedName("items_json") val itemsJson: List<EleItem>,
        // require_receive_time	long	-	否	需要送达时间（毫秒).
        @get:JsonProperty("require_receive_time") @SerializedName("require_receive_time") val requireReceiveTime: Long?,
        // serial_number	string	6	否	商家订单流水号, 方便配送骑手到店取货, 支持数字,字母及#等常见字符. 如不填写, 蜂鸟将截取商家订单号后4位作为流水号.
        @get:JsonProperty("serial_number") @SerializedName("serial_number") val serialNumber: String?
)

/**
 * {
"item_id": "fresh0001",
"item_name": "苹果",
"item_quantity": 5,
"item_price": 10.00,
"item_actual_price": 9.50,
"item_size": 1,
"item_remark": "苹果，轻放",
"is_need_package": 1,
"is_agent_purchase": 1,
"agent_purchase_price": 10.00
}
 */

data class EleItem(
        // string	-	否	商品编号
        @get:JsonProperty("item_id") @SerializedName("item_id") val itemId: String,
        // string	-	是	商品名称
        @get:JsonProperty("item_name") @SerializedName("item_name") val itemName: String,
        // int	-	是	商品数量
        @get:JsonProperty("item_quantity") @SerializedName("item_quantity") val itemQuantity: Int,
        // decimal	-	是	商品原价
        @get:JsonProperty("item_price") @SerializedName("item_price") val itemPrice: Float,
        // 	decimal	-	是	商品实际支付金额
        @get:JsonProperty("item_actual_price") @SerializedName("item_actual_price") val itemActualPrice: Float,
        // 	int	-	否	商品尺寸
        @get:JsonProperty("item_size") @SerializedName("item_size") val itemSize: Int?,
        // string	-	否	商品备注
        @get:JsonProperty("item_remark") @SerializedName("item_remark") val itemRemark: String?,
        // int	-	是	是否需要ele打包 0:否 1:是
        @get:JsonProperty("is_need_package") @SerializedName("is_need_package") val isNeedPackage: Int,
        // int	-	是	是否代购 0:否
        @get:JsonProperty("is_agent_purchase") @SerializedName("is_agent_purchase") val isAgentPurchase: Int,
        // decimal	-	否	代购进价, 如果需要代购 此项必填
        @get:JsonProperty("agent_purchase_price") @SerializedName("agent_purchase_price") val agentPurchasePrice: Float?
)

/**
 * name	string	32	是	门店名称(32个汉字长度，支持汉字、符号、字母的组合)
 * contactPhone	string	-	是	门店联系信息(手机号或座机)
 * address	string	64	是	门店地址(64个汉字长度，支持汉字、符号、字母的组合)
 * longitude	string	-	是	门店经度(数字格式，最长16位数字，包括小数点)
 * latitude	string	-	是	门店纬度(数字格式，最长16位数字，包括小数点)
 * city	string	所在城市
 * positionSource	string	坐标属性（0:未知, 1:腾讯地图, 2:百度地图, 3:高德地图）
 * service	string	配送服务
 * status	string	认证状态（0:未认证, 1:审核中, 2:审核通过, 3:认证失败）
 */
data class QueryEleShop(
        val name: String,
        val contactPhone: String,
        val address: String,
        val longitude: String,
        val latitude: String,
        val city: String,
        val positionSource: String,
        val service: String,
        val status: Int
)

data class EleShop(
        val name: String,
        val contactPhone: String,
        val address: String,
        val longitude: String,
        val latitude: String
)

/**
 * app_id	string	-	是	商户App Id
 * signature	string	-	是	请求签名
 * salt	int	-	是	1000-9999随机数
 * data any 是 业务数据
 */
data class EleAuthPack(
        @get:JsonProperty("app_id") @SerializedName("app_id") val appId: String,
        val salt: Int,
        val signature: String
)

data class OrderInfoEventLog(
        @get:JsonProperty("order_status") @SerializedName("order_status") val orderStatus: Int,
        @get:JsonProperty("occur_time") @SerializedName("occur_time") val occurTime: Long,
        @get:JsonProperty("carrier_driver_name") @SerializedName("carrier_driver_name") val carrierDriverName: String,
        @get:JsonProperty("carrier_driver_phone") @SerializedName("carrier_driver_phone") val carrierDriverPhone: String
)

/**
 * 订单查询数据
 * transport_station_id	int	微仓ID
 * transport_station_tel	string	微仓电话
 * carrier_driver_id	string	配送员ID
 * carrier_driver_name	string	配送员姓名
 * carrier_driver_phone	string	配送员电话
 * estimate_arrive_time	long	预计送达时间（毫秒）
 * order_total_delivery_cost	decimal	配送费
 * order_total_delivery_discount	decimal	配送费折扣
 * order_status	int	订单状态
 * abnormal_code	string	运单异常原因code
 * abnormal_desc	string	运单异常原因描述
 * order_status	int	订单状态（配送阶段）
 * occur_time	long	事件发生事件
 * carrier_driver_name	string	配送员姓名（配送阶段）
 * carrier_driver_phone	string	配送员电话（配送阶段）
 */
data class OrderInfo(
        @get:JsonProperty("transport_station_id") @SerializedName("transport_station_id") val transportStationId: String,
        @get:JsonProperty("transport_station_tel") @SerializedName("transport_station_tel") val transportStationTel: String,
        @get:JsonProperty("carrier_driver_id") @SerializedName("carrier_driver_id") val carrierDriverId: Int,
        @get:JsonProperty("carrier_driver_name") @SerializedName("carrier_driver_name") val carrierDriverName : String,
        @get:JsonProperty("carrier_driver_phone") @SerializedName("carrier_driver_phone") val carrierDriverPhone: String,
        @get:JsonProperty("estimate_arrive_time") @SerializedName("estimate_arrive_time") val estimateArriveTime: Int,
        @get:JsonProperty("order_total_delivery_cost") @SerializedName("order_total_delivery_cost") val orderTotalDeliveryCost: Float,
        @get:JsonProperty("order_total_delivery_discount") @SerializedName("order_total_delivery_discount") val orderTotalDeliveryDiscount: Float,
        @get:JsonProperty("order_status") @SerializedName("order_status") val orderStatus: Int,
        @get:JsonProperty("abnormal_code") @SerializedName("abnormal_code") val abnormalCode: String,
        @get:JsonProperty("abnormal_desc") @SerializedName("abnormal_desc") val abnormalDesc: String,
        @get:JsonProperty("event_log_details") @SerializedName("event_log_details") val eventLogDetails : ArrayList<OrderInfoEventLog>
)

/**
 * carrierPhone	string	骑手电话
 * carrierName	string	骑手姓名
 * latitude	decimal	骑手所在纬度（火星坐标系）
 * longitude	decimal	骑手所在经度（火星坐标系）
 */
data class OrderCarrier(
        val carrierPhone: String,
        val carrierName: String,
        val latitude: Double,
        val longitude: Double
)

/**
 * 订单取消
 * partner_order_code	string	128	是	商户订单号
 * order_cancel_reason_code	int	1	是	订单取消原因代码(2:商家取消)
 * order_cancel_code	int	1	是	订单取消编码（0:其他, 1:联系不上商户, 2:商品已经售完, 3:用户申请取消, 4:运力告知不配送 让取消订单, 5:订单长时间未分配, 6:接单后骑手未取件）
 * order_cancel_description	string	128	否	订单取消描述（order_cancel_code为0时必填）
 * order_cancel_time	long	-	是	订单取消时间（毫秒）
 */
data class OrderCancel(
        @get:JsonProperty("partner_order_code") @SerializedName("partner_order_code") val partnerOrderCode: String,
        @get:JsonProperty("order_cancel_reason_code") @SerializedName("order_cancel_reason_code") val orderCancelReasonCode: Int,
        @get:JsonProperty("order_cancel_code") @SerializedName("order_cancel_code") val orderCancelCode: Int,
        @get:JsonProperty("order_cancel_description") @SerializedName("order_cancel_description") val order_cancel_desc: String,
        @get:JsonProperty("order_cancel_time") @SerializedName("order_cancel_time") val orderCancelTime: Long
)

data class QueryOrderCode(
        // 商户订单号
        @get:JsonProperty("partner_order_code") @SerializedName("partner_order_code") val partnerOrderCode: String
)

data class QueryShopData(
        @get:JsonProperty("chain_store_name") @SerializedName("chain_store_name") val chainStoreName: ArrayList<String>
)

/**
 * 订单投诉
 * "partner_order_code": "BG32141" 	商户订单号
 *
 * "order_complaint_code": 150
 *  订单投诉编码（230:其他, 150:未保持餐品完整, 160:服务态度恶劣, 190:额外索取费用, 170:诱导收货人或商户退单, 140:提前点击送达, 210:虚假标记异常, 220:少餐错餐, 200:虚假配送, 130:未进行配送）
 *
 * "order_complaint_desc": "未保持餐品完整"
 * 订单投诉描述（order_complaint_code为230时必填）
 *
 * "order_complaint_time": 1452570728594
 * 	订单投诉时间（毫秒）
 */
data class OrderComplaint(
        @get:JsonProperty("partner_order_code") @SerializedName("partner_order_code") val partnerOrderCode: String,
        @get:JsonProperty("order_complaint_code") @SerializedName("order_complaint_code") val orderComplaintCode: Int,
        @get:JsonProperty("order_complaint_desc") @SerializedName("order_complaint_desc") val orderComplaintDesc: String,
        @get:JsonProperty("order_complaint_time") @SerializedName("order_complaint_time") val orderComplaintTime: Long
)

data class EleResult(
        val code: Int,
        val msg: String,
        val data: Any?
)
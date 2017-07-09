package cn.imdada

import com.google.gson.annotations.SerializedName

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/6/30
 * 微信: yin80871901
 * http://newopen.cn.imdada.cn/#/development/file/add?_k=nn5yox
 *
 * 新增配送单接口
 * (1) 接口调用URL地址：/api/order/addOrder。
 * (2) 在测试环境，使用统一商户和门店进行发单。其中，商户id：73753，门店编号：11047059。
 */
data class DDOrder (
        @SerializedName("shop_no") val shopNo: String,                      // 门店编号，门店创建后可在门店列表和单页查看
        @SerializedName("origin_id") val originId: String,                  // 第三方订单ID
        @SerializedName("city_code") val cityCode: String,                  // 订单所在城市的code
        @SerializedName("cargo_price") val cargoPrice: Double,              // 订单金额
        @SerializedName("is_prepay") val isPrepay: Int,                     // 订单金额
        // 期望取货时间
        //（
        //  1.时间戳,以秒计算时间，即unix-timestamp;
        //  2.该字段的设定，不会影响达达正常取货;
        //  3.订单被接单后,该时间往后推半小时后，配送员还未取货会自动被系统取消;
        //  4.建议取值为当前时间往后推10~15分钟
        // ）
        @SerializedName("expected_fetch_time") val expectedFetchTime: Long,
        @SerializedName("receiver_name") val receiverName: String,          // 	收货人姓名
        @SerializedName("receiver_address") val receiverAddress: String,    //  收货人地址
        @SerializedName("receiver_lat") val receiverLat: Double,            // 	收货人地址维度（高德坐标系）
        @SerializedName("receiver_lng") val receiverLng: Double,            // 	收货人地址经度（高德坐标系）
        val callback: String,                                               //  回调URL
        //---- 以上为必填字段
        // 	收货人手机号（手机号和座机号必填一项）
        @SerializedName("receiver_phone") var receiverPhone: String? = "13575762817",
        // 	收货人座机号（手机号和座机号必填一项）
        @SerializedName("receiver_tel") var receiverTel: String? = "",
        // 小费（单位：元，精确小数点后一位）
        @SerializedName("tips") var tips: Double,
        // 商家应付金额（单位：元）
        @SerializedName("pay_for_supplier_fee") var payForSupplierFee: Double,
        // 用户应收金额（单位：元）
        @SerializedName("fetch_from_receiver_fee") var fetchFromReceiverFee: Double,
        // 	第三方平台补贴运费金额（单位：元）
        @SerializedName("deliver_fee") var deliverFee: Double,
        // 订单创建时间（时间戳,以秒计算时间，即unix-timestamp）
        @SerializedName("create_time") var createTime: Long,
        // 订单备注
        var info: String,
        // 订单商品类型：1、餐饮 2、饮 料 3、鲜花 4、票 务 5、其他 8、印刷品 9、便利店 10、学校餐饮 11、校园便利 12、生鲜 13、水果
        @SerializedName("cargo_type") var cargoType: Int,
        // 订单重量（单位：Kg）
        @SerializedName("cargo_weight") var cargoWeight: Double,
        // 订单商品数量
        @SerializedName("cargo_num") var cargoNum: Int,
        // 期望完成时间（时间戳,以秒计算时间，即unix-timestamp）
        @SerializedName("expected_finish_time") var expectedFinishTime: Long,
        // 发票抬头
        @SerializedName("invoice_title") var invoiceTitle: String?,
        // 送货开箱码
        @SerializedName("deliver_locker_code") var deliverLockerCode: String?,
        // 取货开箱码
        @SerializedName("pickup_locker_code") var pickupLockerCode: String?,
        // 订单来源标示（该字段可以显示在达达app订单详情页面，只支持字母，最大长度为10）
        @SerializedName("origin_mark") var originMark: String?,
        // 订单来源编号（该字段可以显示在达达app订单详情页面，只支持数字，最大长度为15）
        @SerializedName("origin_mark_no") var originMarkNo: String?
)

// 注册商户
data class DDMerchant (
        val mobile: String,
        // 注册商户手机号,用于登陆商户后台
        @SerializedName("city_name") val cityName: String,
        // 商户城市名称(如,上海)
        @SerializedName("enterprise_name") val enterpriseName: String,
        // 	企业地址
        @SerializedName("enterprise_address") val enterpriseAddress: String,
        // 联系人姓名
        @SerializedName("contact_name") val contactName: String,
        // 	联系人电话
        @SerializedName("contact_phone") val contactPhone: String,
        // 邮箱地址
        @SerializedName("email") val email: String
)

data class DDShop (
       // 门店名称
       @SerializedName("station_name") val stationName: String,
       // 业务类型(食品小吃-1,饮料-2,鲜花-3,文印票务-8,便利店-9,水果生鲜-13,同城电商-19, 医药-20,蛋糕-21,酒品-24,小商品市场-25,服装-26,汽修零配-27,数码-28,小龙虾-29, 其他-5)
       val business: Int,
       // 城市名称(如,上海)
       @SerializedName("city_name") val cityName: String,
       // 区域名称(如,浦东新区)
       @SerializedName("area_name") val areaName: String,
       // 门店地址
       @SerializedName("station_address") val stationAddress: String,
       // 门店经度
       val lng: Double,
       // 门店纬度
       val lat: Double,
       // 联系人姓名
       @SerializedName("contact_name") val contactName: String,
       // 联系人电话
       @SerializedName("phone") val phone: String,
       // 门店编码,可自定义,但必须唯一;若不填写,则系统自动生成
       @SerializedName("origin_shop_id") var originShopId: String,
       // 联系人身份证
       @SerializedName("id_card") val idCard: String?,
       // 达达商家app账号(若不需要登陆app,则不用设置)
       val username: String?,
       // 达达商家app密码(若不需要登陆app,则不用设置)
       val password: String?
)

/**
 * 每次订单状态发生变化时，会对添加订单接口中callback的URL进行回调。
 * 1. 参数以application/json方式传递。若回调服务器响应失败（响应非200），会每隔1分钟重试一次，最多重试10次。
 * 2. 每次订单状态变化都会发生回调，如果出现订单状态回调顺序不一致，请根据回调参数中的时间戳进行判断。
 * 3. 在线上环境中，订单状态的变化会主动触发订单的回调；而在测试环境中，需要模拟订单的各个状态来触发回调。
 * 4. 测试环境，模拟订单各状态的接口如下：
 * 模拟接受订单 link http://newopen.cn.imdada.cn/#/development/file/accept?_k=sxq4n0
 * 模拟完成取货 link http://newopen.cn.imdada.cn/#/development/file/fetch?_k=vvw5tj
 * 模拟完成订单 link http://newopen.cn.imdada.cn/#/development/file/finish?_k=hxijfo
 * 模拟取消订单 link http://newopen.cn.imdada.cn/#/development/file/cancel?_k=agh8xw
 * 模拟订单过期 link http://newopen.cn.imdada.cn/#/development/file/exipre?_k=hs1ut7
 */
const val DDOrderEventStatusWaitForAccept = 1
const val DDOrderEventStatusWaitForFetch = 2
const val DDOrderEventStatusTransport = 3
const val DDOrderEventStatusFinish = 4
const val DDOrderEventStatusCancel = 5
const val DDOrderEventStatusExpire = 7

data class DDOrderEvent(
        // 	预留字段，默认为空
        @SerializedName("client_id") val clientId: String,
        //  添加订单接口中的origin_id值
        @SerializedName("order_id") val orderId: String,
        // 订单状态(待接单＝1 待取货＝2 配送中＝3 已完成＝4 已取消＝5 已过期＝7 指派单=8 系统故障订单发布失败=1000 可参考文末的状态说明）
        @SerializedName("order_status") val orderStatus: Int,
        // 订单取消原因来源(1:达达配送员取消；2:商家主动取消；3:系统或客服取消；0:默认值)
        @SerializedName("cancel_reason") val cancelReason: String,
        // 订单取消原因来源(1:达达配送员取消；2:商家主动取消；3:系统或客服取消；0:默认值)
        @SerializedName("cancel_from") val cancelFrom: Int,
        // 更新时间,时间戳
        @SerializedName("update_time") val updateTime: Int,
        // 对client_id, order_id, update_time的值进行字符串升序排列，再连接字符串，取md5值
        @SerializedName("signature") val signature: String,
        // --- 配送员信息，接单后会存在
        @SerializedName("dm_id") val dmId: String?, // 达达配送员id，接单以后会传
        @SerializedName("dm_name") val dmName: String?,  // 配送员姓名，接单以后会传
        @SerializedName("dm_mobile") val dmMobile: String? // 配送员手机号，接单以后会传
)

/**
 * 取消原因
 */
data class DDReason(
        val id: Int,        // 理由编号
        val reason: String  // 取消理由
)

/**
 * 城市信息
 */
data class DDCity(
        val cityName: String, // 城市名称
        val cityCode: String  // 城市编码
)
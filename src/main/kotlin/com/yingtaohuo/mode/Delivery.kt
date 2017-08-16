package com.yingtaohuo.mode

import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/13
 * 微信: yin80871901
 */

data class PostResult(val ret: Any?, val orderNo: String, val errorCode: Int, val errorMsg: String?)

// 骑手信息
data class DeliveryTransporter(
        val transporterNo: String,  // 骑手编号
        val transporterName: String, // 骑手姓名
        val transporterTel: String, // 骑手联系电话
        val transporterLng: Double, // 骑手经度
        val transporterLat: Double, // 骑手纬度
        val deliveryFee: Int,      // 配送费
        val tips: Int,             // 小费
        val acceptTime: Date?,       // 截单时间
        val fetchTime: Date?,        // 取货时间
        val finishTime: Date?,       // 结束时间
        val cancelTime: Date?,       // 取消时间
        val statusCode: Int,        // 状态码
        val statusMsg: String?      // 订单状态
)

data class Delivery(

        val transportId: Int,                   // 外卖id

        val orderNo: String,            // 订单编号
        val transportChannel: Int,      // 配送渠道

        val receiverAddress: String,    // 收货人信息
        val receiverName: String,       // 收货人姓名
        val receiverTel: String,        // 收货人手机号
        val receiverLat: Double,        // 收货人纬度（火星坐标）
        val receiverLng: Double,        // 收货人经度（火星坐标）

        val status: Int,                // 订单配送状态	订单状态(0未配送成功, 待接单＝1 待取货＝2 配送中＝3 已完成＝4 已取消＝5 已过期＝7 指派单=8 系统故障订单发布失败=1000 可参考文末的状态说明)
        val orderTotalAmount: Int,      // 订单总金额（不包含商家的任何活动以及折扣的金额）,单位分
        val requireReceiveTime: Date,   // 需要送达时间（毫秒).
        val transportFee: Int,          // 配送费
        val transportTips: Int?,         // 小费
        val transportDistance: Long,    // 配送距离
        val createTime: Date,           // 订单创建时间

        val cancelReason: String?,      // 订单取消原因
        val errorMsg: String?,          // 当创建配送订单错误时候的错误信息

        val transporterName: String?,     // 骑手姓名
        val transporterTel: String?,      // 骑手手机号
        val transporterNo: String?,       // 骑手编号
        val transporterLng: Double?,      // 骑手经度
        val transporterLat: Double?,      // 骑手纬度

        val shopName: String,   // 店铺名称
        val shopNo: Int = 1,             // 店铺系统编号
        val shopLng: Double,            // 店铺经度
        val shopLat: Double,            // 店铺纬度

        val acceptTime: Date?,          // 截单时间
        val finishTime: Date?,           // 结束时间
        val fetchTime: Date?,           // 取货时间
        val cancelTime: Date?,           // 取消时间
        val expireTime: Date?,           // 取消时间
        val orderItemNames: String?,      // 订单商品名称
        val remark: String               // 备注
)
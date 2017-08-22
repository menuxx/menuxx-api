package com.yingtaohuo.mode

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/21
 * 微信: yin80871901
 */
data class ShopConfig(
        // 支持 会员充值
        var vipRecharge: Int,
        var deliveryFee: Int,
        // 外卖最低起送 阈值
        var deliveryMinLimit: Int,
        // 外卖渠道
        var transportChannel: Int,
        // 外卖免费阈值
        var deliveryNoFeeLimit: Int,
        var packFee: Int,
        var transportAuto3rd: Int
)
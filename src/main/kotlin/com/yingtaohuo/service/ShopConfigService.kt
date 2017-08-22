package com.yingtaohuo.service

import com.mall.mapper.TConfigMapper
import com.mall.model.TConfig
import com.mall.model.TConfigExample
import com.yingtaohuo.mode.ShopConfig
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/20
 * 微信: yin80871901
 */

@Service
open class ShopConfigService(
        private val configMapper: TConfigMapper
) {

    // 外卖相关
    private val deliveryMinLimitKey = "delivery_min_limit"
    private val deliveryNoFeeLimitKey = "delivery_nofee_limit"
    private val deliveryFeeKey = "delivery_fee"

    private val takeoutMinLimitKey = "takeout_min_limit"
    private val takeoutNoFeeLimitKey = "takeout_nofee_limit"
    private val takeoutFeeKey = "takeout_fee"

    // 打包费
    private val takeoutPackFeeKey = "takeout_pack_fee"
    private val packFeeKey = "pack_fee"

    // vip 充值
    private val vipRechargeKey = "vip_recharge"

    // 配送渠道品
    private val transportChannelKey = "transport_channel"

    private val transportAuto3rdKey = "transport_auto_3rd"

    private fun getShopConfigs(shopId: Int) : List<TConfig>? {
        val ex = TConfigExample()
        ex.createCriteria().andCorpIdEqualTo(shopId)
        return configMapper.selectByExample(ex)
    }

    fun getShopConfig(shopId: Int) : ShopConfig {
        // 默认值
        val config = ShopConfig(
                vipRecharge = 0,
                deliveryFee = 500,
                deliveryMinLimit = 1500,
                deliveryNoFeeLimit = 3000,
                transportChannel = 0,
                packFee = 100,
                transportAuto3rd = 1
        )
        getShopConfigs(shopId)?.forEach { conf ->
            when(conf.name) {
                deliveryMinLimitKey, takeoutMinLimitKey -> config.deliveryMinLimit = conf.value.toInt()
                deliveryNoFeeLimitKey, takeoutNoFeeLimitKey -> config.deliveryNoFeeLimit = conf.value.toInt()
                deliveryFeeKey, takeoutFeeKey -> config.deliveryFee = conf.value.toInt()
                takeoutPackFeeKey, packFeeKey -> config.packFee = conf.value.toInt()
                vipRechargeKey -> config.vipRecharge = conf.value.toInt()
                transportChannelKey -> config.transportChannel = conf.value.toInt()
                transportAuto3rdKey -> config.transportAuto3rd = conf.value.toInt()
            }
        }
        return config
    }

}
package com.yingtaohuo.service

import com.mall.AllOpen
import com.mall.mapper.TDeliveryMerchantMapper
import com.mall.model.TDeliveryMerchant
import com.mall.model.TDeliveryMerchantExample
import com.mall.utils.Util
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/17
 * 微信: yin80871901
 */
@AllOpen
@Service
class DeliveryShopService(private val deliveryShopMapper: TDeliveryMerchantMapper) {

    fun getDeliveryShopByShopId(shopId: Int) : TDeliveryMerchant {
        val ex = TDeliveryMerchantExample()
        ex.createCriteria().andShopIdEqualTo(shopId)
        return Util.onlyOne(deliveryShopMapper.selectByExample(ex))
    }

}
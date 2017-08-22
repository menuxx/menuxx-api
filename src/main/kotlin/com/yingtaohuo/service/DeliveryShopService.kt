package com.yingtaohuo.service

import com.mall.mapper.TDeliveryShopMapper
import com.mall.model.TDeliveryShop
import com.mall.model.TDeliveryShopExample
import com.mall.utils.Util
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/17
 * 微信: yin80871901
 */
@Service
open class DeliveryShopService(val deliveryShopMapper: TDeliveryShopMapper) {

    fun getDeliveryShopByShopId(shopId: Int) : TDeliveryShop {
        val ex = TDeliveryShopExample()
        ex.createCriteria().andShopIdEqualTo(shopId)
        return Util.onlyOne(deliveryShopMapper.selectByExample(ex))
    }

}
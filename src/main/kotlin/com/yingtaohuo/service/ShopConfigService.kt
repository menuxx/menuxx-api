package com.yingtaohuo.service

import com.mall.mapper.TShopConfigMapper
import com.mall.model.TShopConfig
import com.mall.model.TShopConfigExample
import com.mall.utils.Util
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/20
 * 微信: yin80871901
 */

@Service
open class ShopConfigService(
        private val configMapper: TShopConfigMapper
) {

    fun getShopConfig(shopId: Int) : TShopConfig {
        val ex = TShopConfigExample()
        ex.createCriteria().andShopIdEqualTo(shopId)
        return Util.onlyOne(configMapper.selectByExample(ex))
    }

}
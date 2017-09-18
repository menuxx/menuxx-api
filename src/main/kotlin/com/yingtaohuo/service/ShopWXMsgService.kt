package com.yingtaohuo.service

import com.mall.mapper.TWXMsgMapper
import com.mall.model.TWXMsg
import com.mall.model.TWXMsgExample
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/13
 * 微信: yin80871901
 */
@Service
class ShopWXMsgService(private val twxMsgMapper: TWXMsgMapper) {

    fun getTplMsgRangeOfShop(shopId: Int) : List<TWXMsg> {
        val ex = TWXMsgExample()
        ex.createCriteria().andShopIdEqualTo(shopId).andTypeEqualTo(1)
        return twxMsgMapper.selectByExample(ex)
    }

}
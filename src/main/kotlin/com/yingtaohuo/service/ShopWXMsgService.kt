package com.yingtaohuo.service

import com.mall.AllOpen
import com.mall.mapper.TWXMsgMapper
import com.mall.model.TWXMsg
import com.mall.model.TWXMsgExample
import com.mall.utils.Util
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/13
 * 微信: yin80871901
 * 消息类型 （1,购买成功通知, 3, 优惠券通知）
 */

val TplMessageTypeOfBuyNotify = 1
val TplMessageTypeOfBuyNotifyWithDelivery = 2
val TplMessageTypeOfCoupon = 3
val TplMessageTypeOfRefunds = 4
val TplMessageTypeOfSendDelivery = 5

@AllOpen
@Service
class ShopWXMsgService(private val twxMsgMapper: TWXMsgMapper) {

    fun getTplMsgTypeByRangeOfShop(type: Int, shopId: Int) : TWXMsg? {
        val ex = TWXMsgExample()
        ex.createCriteria().andShopIdEqualTo(shopId).andTypeEqualTo(type)
        return Util.onlyOne(twxMsgMapper.selectByExample(ex))
    }

}
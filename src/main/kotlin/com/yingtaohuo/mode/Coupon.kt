package com.yingtaohuo.mode

import com.mall.model.TCoupon
import org.springframework.beans.BeanUtils
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/14
 * 微信: yin80871901
 */
class Coupon : TCoupon {

    constructor(coupon: TCoupon) {
        BeanUtils.copyProperties(coupon, this)
    }

    val expired: Boolean?
        get() = expirationTime.after(Date())

    // 卡券类型(1. 新人立减券，2. 折扣券，3. 满减券，4. 套餐券 5. 代金券)
    val typeText: String?
        get() {
            return when(type) {
                1 -> "新人券"
                2 -> "折扣券"
                3 -> "满减券"
                4 -> "套餐券"
                5 -> "代金券"
                else -> ""
            }
        }
}
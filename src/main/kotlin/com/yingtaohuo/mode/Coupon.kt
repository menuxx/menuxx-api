package com.yingtaohuo.mode

import com.mall.model.TCoupon
import org.springframework.beans.BeanUtils
import java.io.Serializable
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/14
 * 微信: yin80871901
 */

@JvmField val CouponTypeOfNewUser = 1
@JvmField val CouponTypeOfDiscount = 2
@JvmField val CouponTypeOfCutback = 3
@JvmField val CouponTypeOfMoney = 4
@JvmField val CouponTypeOfGroup = 5

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
                CouponTypeOfNewUser -> "新人券"
                CouponTypeOfDiscount -> "折扣券"
                CouponTypeOfCutback -> "满减券"
                CouponTypeOfMoney -> "套餐券"
                CouponTypeOfGroup -> "代金券"
                else -> ""
            }
        }

}
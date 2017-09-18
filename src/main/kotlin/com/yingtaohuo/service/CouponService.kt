package com.yingtaohuo.service

import com.mall.mapper.TCouponConfigMapper
import com.mall.mapper.TCouponMapper
import com.mall.model.TCoupon
import com.mall.model.TCouponConfig
import com.mall.model.TCouponConfigExample
import com.mall.model.TCouponExample
import com.mall.utils.Util
import com.yingtaohuo.mode.Coupon
import com.yingtaohuo.mode.ResponseDataWrap
import org.springframework.stereotype.Service
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/14
 * 微信: yin80871901
 */

val CouponTypeOfNewUser = 1

// 未使用
val CouponNotUsed = 0
val CouponUsed = 1

@Service
class CouponService(
        private val tCouponMapper: TCouponMapper,
        private val tCouponConfigMapper: TCouponConfigMapper
) {

    fun getMyCoupons(userId: Int) : List<Coupon> {
        val now = Date()
        val ex = TCouponExample()
        // 已激活的优惠券
        ex.createCriteria().andEnableEqualTo(1)
                // 未过期
                .andActiveTimeLessThanOrEqualTo(now)
                .andExpirationTimeGreaterThanOrEqualTo(now)
                .andUserIdEqualTo(userId)
                .andUsedEqualTo(CouponNotUsed)

        // 或者是已经激活的永久有效券
        ex.or().andEnableEqualTo(1)
                .andPermanentEqualTo(1)
                .andUserIdEqualTo(userId)
                .andUsedEqualTo(CouponNotUsed)

        return tCouponMapper.selectByExample(ex).map(::Coupon)
    }

    fun activeCoupon(couponId: Int, userId: Int, formId: String) : Int {
        val coupon = TCoupon()
        coupon.userId = userId
        coupon.id = couponId
        coupon.activeTime = Date()
        coupon.pushKey = formId
        coupon.enable = 1
        return tCouponMapper.updateByPrimaryKeySelective(coupon)
    }

    fun getCouponConfigOfShop(shopId: Int, type: Int) : TCouponConfig? {
        val ex = TCouponConfigExample()
        ex.createCriteria()
                .andTypeEqualTo(type)
                .andShopIdEqualTo(shopId)
                // 启用发行
                .andEnableEqualTo(1)
        return Util.onlyOne(tCouponConfigMapper.selectByExample(ex))
    }

    fun insertCouponToUser(coupon: TCoupon) : TCoupon {
        tCouponMapper.insertSelective(coupon)
        return coupon
    }

    /**
     * 获取新用户卡券，如果存在
     */
    fun getMyNewUserCoupon(userId: Int, enable: Int): TCoupon? {
        val now = Date()
        val ex = TCouponExample()

        // 已激活的优惠券
        val a = ex.createCriteria()

        if ( enable != 2 ) {
            a.andEnableEqualTo(enable)
            // 未过期
                    .andActiveTimeLessThanOrEqualTo(now)
                    .andExpirationTimeGreaterThanOrEqualTo(now)
        }
                a.andUserIdEqualTo(userId)
                // 未使用
                .andUsedEqualTo(CouponNotUsed)
                // 卡券类型 -》 新手卡
                .andTypeEqualTo(CouponTypeOfNewUser)

        // 或者是已经激活的永久有效券
        val b = ex.or()
                if (enable != 2) {
                    b.andEnableEqualTo(enable)
                    // 可永久不过期
                            .andPermanentEqualTo(1)
                }

                // 指定用户
                b.andUserIdEqualTo(userId)
                // 卡券类型 -》 新手卡
                .andTypeEqualTo(CouponTypeOfNewUser)
                // 未使用
                .andUsedEqualTo(CouponNotUsed)
        return Util.onlyOne(tCouponMapper.selectByExample(ex))
    }

    fun getMyCoupon(userId: Int, couponId: Int): TCoupon {
        val ex = TCouponExample()
        ex.createCriteria()
                .andUserIdEqualTo(userId)
                .andIdEqualTo(couponId)
        return Util.onlyOne(tCouponMapper.selectByExample(ex))
    }

}
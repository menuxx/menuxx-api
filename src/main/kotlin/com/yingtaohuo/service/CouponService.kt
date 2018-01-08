package com.yingtaohuo.service

import com.mall.AllOpen
import com.mall.mapper.TCouponConfigMapper
import com.mall.mapper.TCouponMapper
import com.mall.model.TCoupon
import com.mall.model.TCouponConfig
import com.mall.model.TCouponConfigExample
import com.mall.model.TCouponExample
import com.mall.utils.Util
import com.yingtaohuo.configure.Publisher
import com.yingtaohuo.mode.Coupon
import com.yingtaohuo.mode.CouponTypeOfNewUser
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Duration
import java.time.LocalDateTime
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/14
 * 微信: yin80871901
 */

// 未使用
val CouponNotUsed = 0
val CouponUsed = 1

@AllOpen
@Service
class CouponService(
        private val tCouponMapper: TCouponMapper,
        private val tCouponConfigMapper: TCouponConfigMapper,
        private val publisher: Publisher
) {

    private val logger = LoggerFactory.getLogger(CouponService::class.java)

    /**
     * 进行卡券推送计划
     * 自卡券产生之日起
     * 2 天后 的中午 1点30 推送一次
     * 4 天后 的中午 1点30 推送一次
     * 6 天后 的下午 1点30 再推送一次
     */
    fun doCouponPushPlan(coupon : Coupon) {

        val exchangeName = "yth.delay"
        val routingKey = "coupon_alert.delay"

        val now = LocalDateTime.now()

        // val date1 = now.plusDays(2).withHour(13).withMinute(30)

        // 2 天后 的中午 1点30 推送一次
        //publisher.sendDelay(exchangeName, routingKey, coupon, Duration.between(now, date1).seconds.toInt())

        // publisher.sendDelay(exchangeName, routingKey, coupon, 10)

        // val date2 = now.plusDays(4).withHour(13).withMinute(30)

        // 4 天后 的中午 1点30 推送一次
        // publisher.sendDelay(exchangeName, routingKey, coupon, 20)

        val date3 = now.plusDays(6).withHour(11)

        // 6 天后 的下午 1点30 再推送一次
        publisher.sendDelay(exchangeName, routingKey, coupon, Duration.between(now, date3).seconds.toInt())

        // publisher.sendDelay(exchangeName, routingKey, coupon, 30)

        logger.debug("coupon plan done!")

    }

    fun getMyCoupons(userId: Int) : List<Coupon>? {
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

        return tCouponMapper.selectByExample(ex)?.map(::Coupon)
    }

    fun usedCoupon(couponId: Int) : Int {
        val coupon = TCoupon()
        coupon.id = couponId
        coupon.used = 1
        return tCouponMapper.updateByPrimaryKeySelective(coupon)
    }

    fun activeCoupon(couponId: Int, userId: Int) : Int {
        val coupon = TCoupon()
        coupon.userId = userId
        coupon.id = couponId
        coupon.activeTime = Date()
        coupon.enable = 1
        return tCouponMapper.updateByPrimaryKeySelective(coupon)
    }

    /**
     * 获取店铺正在发放的卡券
     */
    fun getShopCoupons(shopId: Int) : List<TCouponConfig> {
        val ex = TCouponConfigExample()
        ex.createCriteria().andShopIdEqualTo(shopId)
        return tCouponConfigMapper.selectByExample(ex)
    }

    fun getCouponConfig(configId: Int) : TCouponConfig? {
        return tCouponConfigMapper.selectByPrimaryKey(configId)
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

    @Transactional
    fun insertCouponToUserBatch(coupon: TCoupon, times: Int) : List<Int> {
        return (1..times).map {
            tCouponMapper.insertSelective(coupon)
        }
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
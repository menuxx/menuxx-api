package com.yingtaohuo.controller

import com.mall.AllOpen
import com.mall.annotation.SessionData
import com.mall.annotation.SessionKey
import com.mall.model.TCoupon
import com.mall.service.UserService
import com.yingtaohuo.mode.Coupon
import com.yingtaohuo.mode.CouponTypeOfNewUser
import com.yingtaohuo.mode.ResponseDataWrap
import com.yingtaohuo.service.CouponService
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/14
 * 微信: yin80871901
 */

@AllOpen
@RestController
@RequestMapping("/shops/{shopId}")
class CouponController(
        private val couponService: CouponService,
        private val userService: UserService
){

    /**
     * 获取新手券
     */
    @GetMapping("/coupons/getnewuser")
    fun getNewUserCoupon(@SessionKey session: SessionData, @PathVariable("shopId") shopId: Int) : ResponseDataWrap {
        // 为用户添加 新手立减券
        val user = userService.selectUser(session.userId)
        val config = couponService.getCouponConfigOfShop(shopId, CouponTypeOfNewUser)
        // 获取新授权
        val newUserCoupon = couponService.getMyNewUserCoupon(session.userId, 2)
        // 如果未消费过
        if (user.consumed == 0 && config != null && newUserCoupon == null) {
            val coupon = TCoupon()
            coupon.shopId = shopId
            coupon.userId = user.id
            coupon.createTime = Date()
            coupon.expirationTime = Date.from(Date().toInstant().plusSeconds(TimeUnit.DAYS.toSeconds(config.expirationDay.toLong())))
            // 从末模板中 复制对应的 数据
            coupon.name = config.name
            coupon.type = config.type
            coupon.cutback = config.cutback / config.newUserCouponRelease
            coupon.toup = config.toup
            coupon.descText = config.descText
            coupon.discount = config.discount
            coupon.permanent = config.permanent
            // 待激活
            coupon.enable = 0
            // 微信 推送 key
            return ResponseDataWrap(couponService.insertCouponToUserBatch(coupon, config.newUserCouponRelease), 0, false)
        }
        return ResponseDataWrap(newUserCoupon, 0, false)
    }

    /**
     * 获取我的所有券
     */
    @GetMapping("/coupons")
    fun getMyCoupons(@SessionKey session: SessionData) : ResponseDataWrap {
        return ResponseDataWrap(couponService.getMyCoupons(session.userId), 0, false)
    }

    /**
     * 获取我的卡券
     */
    @GetMapping("/coupons/{couponId}")
    fun getCouponById(@SessionKey session: SessionData, @PathVariable("couponId") couponId: Int) : ResponseDataWrap {
        val coupon = Coupon(couponService.getMyCoupon(session.userId, couponId))
        return ResponseDataWrap(coupon, 0, false)
    }

    /**
     * 优惠券激活
     */
    @PutMapping("/coupons/{couponId}/active")
    fun activeCoupon(@PathVariable("couponId") couponId: Int, @SessionKey session: SessionData) : ResponseDataWrap {
        val arow = couponService.activeCoupon(couponId, session.userId)
        val coupon = couponService.getMyCoupon(session.userId, couponId)
        // 完成卡券推送计划
        couponService.doCouponPushPlan(Coupon(coupon))
        return if (arow > 0) {
            ResponseDataWrap(couponId, 0, false)
        } else {
            ResponseDataWrap(0, -1, true)
        }
    }

}

// 消息类型 （1,购买成功通知(普通), 2,购买成功通知(外卖) 3, 优惠券通知 4, 退款消息 5, 订单发货 ）
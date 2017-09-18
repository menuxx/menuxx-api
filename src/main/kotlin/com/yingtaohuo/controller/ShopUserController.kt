package com.yingtaohuo.controller

import com.mall.annotation.SessionData
import com.mall.service.CorpService
import com.mall.service.CorpUserService
import com.mall.utils.SMSUtil
import com.mall.utils.Util
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/30
 * 微信: yin80871901
 */

@RestController
class ShopUserController(
        private val corpUserService: CorpUserService,
        private val corpService: CorpService
) {

    @PostMapping("/shop_login/{phone}")
    @ResponseBody
    fun login(@PathVariable phone: String, @RequestBody body: Map<String, String>): ResponseEntity<*> {
        val captcha = body["captcha"] ?: return Util.status400("手机动态码必填")
        if (!SMSUtil.checkCaptcha(phone, captcha)) {
            return Util.status401("手机号和验证码不匹配")
        }
        val corpUser = corpUserService.selectCorpUserByMobile(phone) ?: return Util.status401("该手机号未绑定店铺，请联系工作人员 0571-28181820")
        val corp = corpService.selectCorpForMap(corpUser.corpId!!)
        val sessionData = SessionData("", "", corpUser.id!!, corpUser.corpId.toString(), corpUser.corpId)
        val map = mapOf("account" to corpUser, "shop" to corp, "sessionToken" to sessionData.sessionToken)
        return ResponseEntity<Map<String, Any>>(map, HttpStatus.OK)
    }

}
package com.yingtaohuo.controller

import com.mall.annotation.SessionData
import com.mall.annotation.SessionKey
import com.yingtaohuo.mode.PushKey
import com.yingtaohuo.mode.ResponseDataWrap
import com.yingtaohuo.service.PushKeyService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/29
 * 微信: yin80871901
 */

@RestController
@RequestMapping("/shops/{shopId}/push_keys")
open class PushKeyController (private val pushKeyService : PushKeyService) {

    @PostMapping("/")
    open fun addPushKey(@PathVariable shopId: Int, @SessionKey session: SessionData, @Valid @RequestBody pushKey: PushKey) : ResponseDataWrap {
        val tPushKey = pushKey.toTPushKey()
        tPushKey.userId = session.userId
        tPushKey.shopId = shopId
        return if ( pushKeyService.insertKey(tPushKey) ) {
            ResponseDataWrap(true, 0, false)
        } else {
            ResponseDataWrap(false, -1, true)
        }
    }

}
package com.yingtaohuo.controller

import com.mall.AllOpen
import com.mall.service.ConfigService
import com.yingtaohuo.mode.ResponseDataWrap
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/18
 * 微信: yin80871901
 */
@AllOpen
@RestController
@RequestMapping("/shops/{shopId}")
class ShopController(
        private val configService: ConfigService
) {

    data class ShopBusinessTimeline(@NotEmpty val timeline: String)
    @PutMapping("/business_timeline")
    fun updateShopTimeline(@PathVariable("shopId") shopId: Int, @Valid @RequestBody timeline: ShopBusinessTimeline) : ResponseDataWrap {
        if ( timeline.timeline.startsWith("0;") ) {
            configService.updateShopInWork(shopId, 2)
        } else {
            configService.updateShopInWork(shopId, 1)
        }
        return ResponseDataWrap(timeline, 0, true)
    }

}
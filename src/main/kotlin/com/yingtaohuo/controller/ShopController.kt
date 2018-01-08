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
class ShopController(private val configService: ConfigService) {

    data class ShopBusinessTimeline(@NotEmpty val timeline: String)
    @PutMapping("/business_timeline")
    fun updateShopTimeline(@PathVariable("shopId") shopId: Int, @Valid @RequestBody timeline: ShopBusinessTimeline) : ResponseDataWrap {
        var tt = timeline.timeline
        if ( tt.startsWith("0;") ) {
            if ( timeline.timeline.replaceFirst("0;".toRegex(), "").isEmpty() ) {
                tt = "0;0-24"
            }
        }
        if ( tt.isEmpty() ) {
            tt = "0-24"
        }
        return if ( configService.saveBusinessTimeline(shopId, tt) > 0 ) {
            ResponseDataWrap(tt, 0, true)
        } else {
            ResponseDataWrap(tt, -1, false)
        }
    }

}
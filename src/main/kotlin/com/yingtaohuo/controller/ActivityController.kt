package com.yingtaohuo.controller

import com.yingtaohuo.mode.Activity
import com.yingtaohuo.service.ActivityService
import org.springframework.web.bind.annotation.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/10
 * 微信: yin80871901
 */
@RestController
@RequestMapping("/diners/{shopId}")
open class ActivityController (
        private val activityService: ActivityService
) {

    @GetMapping("/activities")
    fun getShopActivities(@PathVariable shopId: Int, @RequestParam("available") available: Int) : List<Activity>? {
        return if (available == 1) {
            val tacs = activityService.selectShopAvailableActivity(shopId)
            tacs?.map { activityService.getActivity(it) }
        } else {
            val tacs = activityService.selectShopActivity(shopId)
            tacs?.map { activityService.getActivity(it) }
        }
    }

}
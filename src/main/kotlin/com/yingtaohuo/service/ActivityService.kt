package com.yingtaohuo.service

import com.mall.mapper.TActivityMapper
import com.mall.mapper.TActivityMinusMapper
import com.mall.model.TActivity
import com.mall.model.TActivityExample
import com.mall.model.TActivityMinusExample
import com.yingtaohuo.mode.Activity
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/10
 * 微信: yin80871901
 */
@Service
open class ActivityService(
        internal val activityMapper: TActivityMapper,
        internal val activityMinusMapper: TActivityMinusMapper
) {

    fun selectShopAvailableActivity(shopId: Int) : List<TActivity>? {
        val tex = TActivityExample()
        val now = Date()
        tex.createCriteria()
                // 查询时间范围内符合的活动
                .andStartTimeLessThan(now)
                .andEndTimeGreaterThan(now)
                .andCorpIdEqualTo(shopId)
                .andStatusEqualTo(1)   // 状态激活的就参与计算
        return activityMapper.selectByExample(tex)
    }

    fun selectShopActivity(shopId: Int) : List<TActivity>? {
        val tex = TActivityExample()
        tex.createCriteria().andCorpIdEqualTo(shopId)
        return activityMapper.selectByExample(tex)
    }

    fun getActivity(activity: TActivity) : Activity {
        val tame = TActivityMinusExample()
        tame.createCriteria().andCorpIdEqualTo(activity.corpId)
        val minus = activityMinusMapper.selectByExample(tame)
        val act = Activity(minus)
        BeanUtils.copyProperties(activity, act)
        return act
    }

}
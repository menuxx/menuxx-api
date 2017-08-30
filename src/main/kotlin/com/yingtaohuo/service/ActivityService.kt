package com.yingtaohuo.service

import com.mall.mapper.TActivityMapper
import com.mall.mapper.TActivityMinusMapper
import com.mall.mapper.TActivityNewUserMapper
import com.mall.model.*
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
        private val activityMapper: TActivityMapper,
        private val activityMinusMapper: TActivityMinusMapper,
        private val activityNewUserMapper: TActivityNewUserMapper
) {

    /**
     * 找出该店铺当前能支持的活动
     */
    fun selectShopAvailableActivity(shopId: Int) : List<TActivity>? {
        val tex = TActivityExample()
        val now = Date()
        tex.createCriteria()
                // 查询时间范围内符合的活动
                .andStartTimeLessThan(now)
                .andEndTimeGreaterThan(now)
                .andCorpIdEqualTo(shopId)
                .andStatusEqualTo(1)   // 状态激活的就参与计算
        tex.orderByClause = "weight desc"
        return activityMapper.selectByExample(tex)
    }

    fun selectAvailableActivityMinus(activityId: Int) : List<TActivityMinus> {
        val tex = TActivityMinusExample()
        tex.createCriteria().andActivityIdEqualTo(activityId)
                .andEnableEqualTo(1)
        return activityMinusMapper.selectByExample(tex)
    }

    fun selectAvailableActivityNewUser(activityId: Int) : List<TActivityNewUser> {
        val tex = TActivityNewUserExample()
        tex.createCriteria().andActivityIdEqualTo(activityId)
                .andEnableEqualTo(1)
        return activityNewUserMapper.selectByExample(tex)
    }

    fun selectShopActivity(shopId: Int) : List<TActivity>? {
        val tex = TActivityExample()
        tex.createCriteria().andCorpIdEqualTo(shopId)
        return activityMapper.selectByExample(tex)
    }

    fun getActivity(activity: TActivity) : Activity {
        val tame = TActivityMinusExample()
        tame.createCriteria().andActivityIdEqualTo(activity.id).andEnableEqualTo(1)
        val minus = activityMinusMapper.selectByExample(tame)
        val act = Activity(minus)
        BeanUtils.copyProperties(activity, act)
        return act
    }



}
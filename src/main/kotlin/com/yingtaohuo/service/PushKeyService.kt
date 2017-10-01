package com.yingtaohuo.service

import com.mall.mapper.PushKeyMapper
import com.mall.mapper.TPushKeyMapper
import com.mall.model.TPushKey
import com.mall.model.TPushKeyExample
import com.mall.utils.Util
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/29
 * 微信: yin80871901
 */

@JvmField val PushKeyTypeOfFormID = 1
@JvmField val PushKeyTypeOfPrepayId = 2

@Service
open class PushKeyService (private val tPushKeyMapper: TPushKeyMapper, private val pushKeyMapper: PushKeyMapper) {

    // 添加新的 push_key
    fun insertKey(pushKey: TPushKey) : Boolean {
        return tPushKeyMapper.insertSelective(pushKey) > 0
    }

    // 使用次数增加
    fun timesIncrementByKeyId(keyId: Int) : Boolean {
        val timesRecord = tPushKeyMapper.selectByPrimaryKey(keyId)
        timesRecord.times += 1
        return tPushKeyMapper.updateByPrimaryKeySelective(timesRecord) > 0
    }

    // 使用次数增加
    fun timesIncrementByKey(key: String) : Boolean {
        val ex = TPushKeyExample()
        ex.createCriteria().andPushKeyEqualTo(key)
        val timesRecord = Util.onlyOne(tPushKeyMapper.selectByExample(ex))
        timesRecord.times += 1
        return tPushKeyMapper.updateByPrimaryKeySelective(timesRecord) > 0
    }

    fun getUserAvailableKey(userId: Int) : TPushKey? {
        // 7 天后过期的不要
        val date = Date.from(LocalDateTime.now().minusDays(7).toInstant(ZoneOffset.UTC))
        val keys = pushKeyMapper.selectAvailableKeysByUserId(userId, date)
        return if (keys != null && keys.isNotEmpty()) {
            keys.first()
        } else {
            null
        }
    }

}
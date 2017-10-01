package com.yingtaohuo.mode

import com.mall.model.TPushKey
import org.hibernate.validator.constraints.NotEmpty
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/29
 * 微信: yin80871901
 */
data class PushKey(
        val id: Int,
        val userId: Int,
        val shopId: Int,
        val times: Int,
        @NotEmpty
        val keyType: Int,
        @NotEmpty
        val pushKey: String,
        var createTime: Date?,
        var updateTime: Date?
) {
    fun toTPushKey() : TPushKey {
        val key = TPushKey()
        key.id = id
        key.userId = userId
        key.shopId = shopId
        key.times = times
        key.keyType = keyType
        key.pushKey = pushKey
        key.createTime = createTime
        key.updateTime = updateTime
        return key
    }
}
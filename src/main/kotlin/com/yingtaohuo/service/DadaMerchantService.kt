package com.yingtaohuo.service

import com.mall.mapper.TDadaMerchantMapper
import com.mall.model.*
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/7
 * 微信: yin80871901
 */

@Service
open class DadaMerchantService(
        val dadaMerchantMapper: TDadaMerchantMapper
) {
    fun getById(id: Int): TDadaMerchant {
        return dadaMerchantMapper.selectByPrimaryKey(id)
    }
}
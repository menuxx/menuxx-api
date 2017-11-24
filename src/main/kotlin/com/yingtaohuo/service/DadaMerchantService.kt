package com.yingtaohuo.service

import com.mall.mapper.TDadaMerchantMapper
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/7
 * 微信: yin80871901
 */

@Service
open class DadaMerchantService(
        private val dadaMerchantMapper: TDadaMerchantMapper
) {
    fun getById(id: Int) = dadaMerchantMapper.selectByPrimaryKey(id)
}
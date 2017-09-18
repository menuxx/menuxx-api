package com.yingtaohuo.controller

import com.mall.mapper.TTableMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/9
 * 微信: yin80871901
 */
@RestController
@RequestMapping("/diners/{dinerId}")
open class TableController(internal val tableMapper: TTableMapper) {

    @GetMapping("/tables/{tableId}")
    fun getTable(@PathVariable tableId: Int) = tableMapper.selectByPrimaryKey(tableId)!!

}
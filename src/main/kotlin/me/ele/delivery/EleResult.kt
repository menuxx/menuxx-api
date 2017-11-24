package me.ele.delivery

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/1
 * 微信: yin80871901
 */

data class Result<out T>(val code: Int, val msg: String, val data: T)

class EleEmpty
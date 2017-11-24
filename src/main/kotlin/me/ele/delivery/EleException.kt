package me.ele.delivery

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/3
 * 微信: yin80871901
 */
class EleException(val code: Int, val msg: String?) : RuntimeException(msg)
package cn.imdada

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/6
 * 微信: yin80871901
 */
class ImDadaException(val status: String?, val code: Int, override val message: String) : Exception()
package com.mall.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/13
 * 微信: yin80871901
 */
@ResponseStatus(value= HttpStatus.BAD_GATEWAY, reason="Pay Error")  // 404
class WXPayException : RuntimeException {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
}
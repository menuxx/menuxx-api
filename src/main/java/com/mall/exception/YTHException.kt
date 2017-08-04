package com.mall.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/19
 * 微信: yin80871901
 */
@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE, reason="Not Support")  // 404
class NotSupportException: RuntimeException {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
}

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Not Found")  // 404
class NotFoundException : RuntimeException {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
}
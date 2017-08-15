package com.mall.exception

import cn.imdada.ImDadaException
import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.sql.SQLException

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/19
 * 微信: yin80871901
 */

data class Error(val errorCode: Int, val errorMsg: String?)

@ControllerAdvice
class GlobalControllerExceptionHandler {

    // 空指指针异常错误
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="服务器存在不安全错误")
    @ExceptionHandler(NullPointerException::class)
    @ResponseBody
    fun nullError(ex: NullPointerException) : Error {
        ex.printStackTrace()
        return Error(500, ex.message)
    }

    // 未发现数据
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="未发现需要的数据")
    @ExceptionHandler(NotFoundException::class)
    @ResponseBody
    fun notFound(ex: NotFoundException) : Error {
        ex.printStackTrace()
        return Error(404, ex.message)
    }

    // 数据库错误
    @ResponseStatus(value=HttpStatus.SERVICE_UNAVAILABLE, reason="数据库访问错误")
    @ExceptionHandler(*arrayOf(SQLException::class, DataAccessException::class))
    @ResponseBody
    fun databaseError(ex: Exception) : Error {
        ex.printStackTrace()
        return Error(500, ex.message)
    }

    // 达达错误
    @ResponseStatus(value=HttpStatus.SERVICE_UNAVAILABLE, reason="达达配送接口调用错误")
    @ExceptionHandler(ImDadaException::class)
    @ResponseBody
    fun imdadaError(ex: ImDadaException) : Error {
        ex.printStackTrace()
        return Error(500, ex.message)
    }

    // 位置错位
    @ExceptionHandler(Exception::class)
    @ResponseBody
    fun otherwise(ex: Exception) : Error {
        ex.printStackTrace()
        return Error(400, ex.message)
    }

}
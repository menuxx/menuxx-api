package com.yingtaohuo.util

import java.util.*
import kotlin.collections.ArrayList

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/16
 * 微信: yin80871901
 *
 * 以0开头为，无条件暂停营业
 *
 * 例如：一个 0 为，无条件停业 0;8-23 也为立即停业
 *
 * 8-23 为 每天 8 点至 23 点营业
 *
 * 8-23;;;;;10-24; 周一到周五 8 点至 23 点营业 周六 周日 10 点至 24 点营业
 *
 * 8-12,14-18 每天上午8-12点营业，下午14至18点营业
 *
 * 8-12,14-18;;;;;0;0 每天上午8-12点营业，下午14至18点营业 周六周日不营业
 *
 * 8.5-22.5 每天上午8点半至晚上10点半营业
 */

// fun main(args: Array<String>) {
    // println(TimeLineFactory("0;8-23;;;;10-24;;").inRange(Date()))
    // println(TimeLineFactory("0;8-23;;;;10-24;;").inRange(Date()))

    // println(TimeLineFactory("0;8-23").getWorkTime(Date()))
//}

/**
 * 小时时间单位
 */
class TimeUnit(node: String) {

    private val c = Calendar.getInstance()

    // 当开始时间和结束时间 都是 0.0 的时候，标识该时段打样
    private var startTime: Float = 0.0f

    private var endTime: Float = 0.0f

    init {
        val _times = node.split("-")
        if (_times.size < 2) {
            throw IllegalArgumentException("格式错误，一个时段至少有两个时间组成 例如：8-23")
        }
        if (_times.size > 2) {
            throw IllegalArgumentException("格式错误，一个时段最多有两个时间组成 例如：8-23")
        }
        try {
            startTime = _times[0].toFloat()
            endTime = _times[1].toFloat()
        } catch (ex: NumberFormatException) {
            throw IllegalArgumentException("时段数字必须为一个数字 如果为小数 比如 8.5 就代表 8点半 ${ex.message}")
        }
    }

    fun inRange(date: Date) : Boolean {
        c.time = date
        val nowTime = c.get(Calendar.HOUR_OF_DAY) + (c.get(Calendar.MINUTE).toFloat() / 60)
        return nowTime in startTime..endTime
    }

    override fun toString(): String {
        var str = ""
        val start = startTime.toString().split(".")
        str += if (start.size > 1) {
            val _start = (start[1].toFloat() * 60).toInt()
            if (_start == 0) {
                "${start[0]}点"
            } else {
                "${start[0]}点${_start}分"
            }
        } else {
            "${start[0]}点"
        }
        str += "至"
        val end = endTime.toString().split(".")
        str += if (start.size > 1) {
            val _end = (end[1].toFloat() * 60).toInt()
            if (_end == 0) {
                "${end[0]}点营业"
            } else {
                "${end[0]}点${_end}营业"
            }
        } else {
            "${end[0]}点营业"
        }
        return str
    }
}

/**
 * 天单位
 */
class DayUnit(nodes: String) {

    private var noRange = false

    private val stages: ArrayList<TimeUnit> = ArrayList()

    init {
        val _stages = nodes.split(",")
        if ( _stages.isEmpty() ) {
            throw IllegalArgumentException("时段规则不能为空")
        }
        for (_st in _stages) {
            // 当 该日 为 0 的时候，当天不营业
            if (_st == "0") {
                noRange = true
            } else {
                stages.addAll(_stages.map(::TimeUnit))
            }
        }
    }

    fun inRange(date: Date) : Boolean {
        return !noRange && stages.findLast { s -> s.inRange(date) } != null
    }

    override fun toString(): String {
        if (noRange) {
            return "客官今天打样"
        }
        return "今天" + stages.joinToString(",") + ", 其他时间不营业"
    }
}

/**
 * 周时间单位
 */
class WeekUnit(nodes: String) {

    private val c = Calendar.getInstance()

    private val dayNodes: ArrayList<DayUnit> = ArrayList()

    init {

        // 分割 ; 天

        val _dayNodes = nodes.split(";")

        var preDay : DayUnit? = null

        if (_dayNodes.isEmpty()) {
            throw IllegalArgumentException("至少有一天营业时间规则")
        }

        for (dayNum in 0..6) {

            // 如果 用户 有更多的规则定义
            if (_dayNodes.size > dayNum) {

                if (dayNum == 0 && _dayNodes[dayNum].isEmpty()) {
                    throw IllegalArgumentException("当只有一天营业规则的时候，规则不能为空")
                }

                if ( !_dayNodes[dayNum].isEmpty() ) {
                    val day = DayUnit(_dayNodes[dayNum])
                    preDay = day
                    dayNodes.add(day)
                }
                // 如果是一个空字符串，那么就等于前一天
                else {
                    dayNodes.add(preDay!!)
                }
            } else {
                dayNodes.add(preDay!!)
            }
        }

    }

    fun inRange(date: Date) : Boolean {
        return dayNodes.findLast { d -> d.inRange(date) } != null
    }

    fun getWorkTime(date: Date) : String {
        c.time = date
        val weekIndex = c.get(Calendar.DAY_OF_WEEK)
        return dayNodes[ 7 - weekIndex ].toString()
    }

}

class TimeLineFactory(private val nodes: String) {

    private var week: WeekUnit?= null

    init {
        val t = nodes.replaceFirst("^0;".toRegex(), "")
        if (t.isNotEmpty()) {
            week = WeekUnit(t)
        }
    }

    /**
     * 当前时间是否在工作范围之类
     */
    fun inRange(date: Date) : Boolean {
        // 是否以0开头
        return if ( nodes.startsWith("0;") ) {
            false
        } else {
            week!!.inRange(date)
        }
    }

    /**
     * 获得工作时间表
     */
    fun getWorkTime(date: Date) : String? {
        if (week != null) {
            if (nodes.startsWith("0")) {
                return "尊敬的顾客，老板急事，暂停营业"
            }
            return week!!.getWorkTime(date)
        }
        return null
    }

}
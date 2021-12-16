package com.max.cathay_pacific.util

import java.util.*

object CalendarUtil {

    private val GMT_PLUS_EIGHT_TIME_ZONE: TimeZone = TimeZone.getTimeZone("GMT+8")

    /**
     * 取得Taiwan時區的時間
     *
     * @return Calendar
     */
    fun getTaiwanTime(): Calendar {
        return Calendar.getInstance(GMT_PLUS_EIGHT_TIME_ZONE)
    }
}

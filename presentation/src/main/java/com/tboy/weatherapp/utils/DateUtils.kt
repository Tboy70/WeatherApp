package com.tboy.weatherapp.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    fun getDate(time: Int): String? {
        val date = Date(time * 1000L) // *1000 is to convert seconds to milliseconds
        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.FRANCE) // the format of your date
        sdf.timeZone = TimeZone.getTimeZone("GMT+1")
        return sdf.format(date)
    }
}
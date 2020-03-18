package com.tboy.data.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.tboy.data.db.entity.DailyWeatherDBEntity

class DailyWeatherConverter {

    @TypeConverter
    fun listToJson(value: List<DailyWeatherDBEntity>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<DailyWeatherDBEntity>? {

        val objects = Gson().fromJson(
            value,
            Array<DailyWeatherDBEntity>::class.java
        ) as Array<DailyWeatherDBEntity>
        return objects.toList()
    }
}
package com.tboy.data.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.tboy.data.db.entity.ForecastWeatherDBEntity

class ForecastWeatherConverter {

    @TypeConverter
    fun listToJson(value: List<ForecastWeatherDBEntity>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<ForecastWeatherDBEntity>? {

        val objects = Gson().fromJson(
            value,
            Array<ForecastWeatherDBEntity>::class.java
        ) as Array<ForecastWeatherDBEntity>
        return objects.toList()
    }
}
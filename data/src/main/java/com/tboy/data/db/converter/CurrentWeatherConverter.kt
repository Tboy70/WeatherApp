package com.tboy.data.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.tboy.data.db.entity.CurrentWeatherDBEntity

class CurrentWeatherConverter {

    @TypeConverter
    fun listToJson(value: List<CurrentWeatherDBEntity>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<CurrentWeatherDBEntity>? {

        val objects = Gson().fromJson(
            value,
            Array<CurrentWeatherDBEntity>::class.java
        ) as Array<CurrentWeatherDBEntity>
        return objects.toList()
    }
}
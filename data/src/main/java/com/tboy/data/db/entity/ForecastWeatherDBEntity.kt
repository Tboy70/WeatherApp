package com.tboy.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.tboy.data.db.converter.DailyWeatherConverter

@Entity
@TypeConverters(DailyWeatherConverter::class)
data class ForecastWeatherDBEntity(
    @PrimaryKey(autoGenerate = true)
    val idForecastWeather: Int = 0,
    val generalSummary: String? = null,
    val generalIcon: String? = null,
    val data: List<DailyWeatherDBEntity>? = emptyList()
)
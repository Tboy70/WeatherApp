package com.tboy.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DailyWeatherDBEntity(
    @PrimaryKey(autoGenerate = true)
    val idDailyWeather: Int = 0,
    val time: Int? = null,
    val summary: String? = null,
    val icon: String? = null,
    val precipIntensity: Double? = null,
    val precipProbability: Double? = null,
    val precipType: String? = null,
    val humidity: Double? = null,
    val pressure: Double? = null,
    val windSpeed: Double? = null,
    val cloudCover: Double? = null,
    val temperatureMin: Double? = null,
    val temperatureMax: Double? = null,
    val apparentTemperatureMin: Double? = null,
    val apparentTemperatureMax: Double? = null
)
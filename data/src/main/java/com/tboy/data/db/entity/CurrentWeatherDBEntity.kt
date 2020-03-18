package com.tboy.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrentWeatherDBEntity(
    @PrimaryKey(autoGenerate = true)
    val idCurrentWeather: Int = 0,
    val time: Int? = null,
    val summary: String? = null,
    val icon: String? = null,
    val precipIntensity: Double? = null,
    val precipProbability: Double? = null,
    val temperature: Double? = null,
    val humidity: Double? = null,
    val apparentTemperature: Double? = null,
    val pressure: Double? = null,
    val windSpeed: Double? = null,
    val cloudCover: Double? = null
)
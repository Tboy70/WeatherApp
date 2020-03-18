package com.tboy.data.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.TypeConverters
import com.tboy.data.db.converter.CurrentWeatherConverter
import com.tboy.data.db.converter.ForecastWeatherConverter

@Entity(primaryKeys = ["latitude", "longitude"])
@TypeConverters(CurrentWeatherConverter::class, ForecastWeatherConverter::class)
data class WeatherResultDBEntity(
    val timezone: String,
    val latitude: Double,
    val longitude: Double,
    @Embedded
    val currentWeather: CurrentWeatherDBEntity? = null,
    @Embedded
    val forecastWeather: ForecastWeatherDBEntity? = null
)
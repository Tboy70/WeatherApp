package com.tboy.data.entity

data class WeatherResultEntity(
    var timezone: String,
    var latitude: Double,
    var longitude: Double,
    var currentWeather: CurrentWeatherEntity? = null,
    var forecastWeather: ForecastWeatherEntity? = null
)
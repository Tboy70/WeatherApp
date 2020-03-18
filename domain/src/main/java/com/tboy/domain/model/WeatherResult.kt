package com.tboy.domain.model

data class WeatherResult(
    var timezone: String,
    var latitude: Double,
    var longitude: Double,
    var currentWeather: CurrentWeather? = null,
    var forecastWeather: ForecastWeather? = null
)
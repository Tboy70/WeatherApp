package com.tboy.data.entity

data class ForecastWeatherEntity(
    val time: Int? = null,
    val summary: String? = null,
    val icon: String? = null,
    val precipIntensity: Float? = null,
    val precipProbability: Float? = null,
    val precipType: Float? = null,
    val humidity: Float? = null,
    val pressure: Float? = null,
    val windSpeed: Float? = null,
    val cloudCover: Float? = null,
    val temperatureMin: Float? = null,
    val temperatureMax: Float? = null,
    val apparentTemperatureMin: Float? = null,
    val apparentTemperatureMax: Float? = null
)
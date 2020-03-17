package com.tboy.data.entity

data class CurrentWeatherEntity(
    val time: Int? = null,
    val summary: String? = null,
    val icon: String? = null,
    val precipIntensity: Float? = null,
    val precipProbability: Float? = null,
    val temperature: Float? = null,
    val humidity: Float? = null,
    val apparentTemperature: Float? = null,
    val pressure: Float? = null,
    val windSpeed: Float? = null,
    val cloudCover: Float? = null
)
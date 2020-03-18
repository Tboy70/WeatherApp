package com.tboy.domain.model

data class CurrentWeather(
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
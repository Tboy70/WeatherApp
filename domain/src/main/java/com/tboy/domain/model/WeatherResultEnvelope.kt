package com.tboy.domain.model

data class WeatherResultEnvelope(
    var timezone: String? = null,
    var latitude: Float? = null,
    var longitude: Float? = null,
    var currentWeather: CurrentWeather? = null,
    var forecastWeather: ForecastWeather? = null
)
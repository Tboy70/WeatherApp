package com.tboy.domain.model

data class WeatherResultEnvelope(
    var latitude: Float? = null,
    var longitude: Float? = null,
    var currentWeather: CurrentWeather? = null,
    var forecastWeather: List<ForecastWeather>? = emptyList()
)
package com.tboy.data.entity

data class WeatherResultEnvelopeEntity(
    var latitude: Float? = null,
    var longitude: Float? = null,
    var currentWeather: CurrentWeatherEntity? = null,
    var forecastWeather: List<ForecastWeatherEntity>? = emptyList()
)
package com.tboy.data.entity

data class WeatherResultEnvelopeEntity(
    var timezone: String? = null,
    var latitude: Float? = null,
    var longitude: Float? = null,
    var currentWeather: CurrentWeatherEntity? = null,
    var forecastWeather: ForecastWeatherEntity? = null
)
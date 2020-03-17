package com.tboy.data.entity.remote

import com.google.gson.annotations.SerializedName

data class WeatherResultEnvelopeRemoteEntity(
    @SerializedName("latitude") var latitude: Float? = null,
    @SerializedName("longitude") var longitude: Float? = null,
    @SerializedName("currently") var currentWeather: CurrentWeatherRemoteEntity? = null,
    @SerializedName("daily") var forecastWeather: ForecastWeatherRemoteEntity? = null
)
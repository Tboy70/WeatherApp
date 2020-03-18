package com.tboy.data.entity.remote

import com.google.gson.annotations.SerializedName

data class WeatherResultRemoteEntity(
    @SerializedName("timezone") var timezone: String,
    @SerializedName("latitude") var latitude: Double,
    @SerializedName("longitude") var longitude: Double,
    @SerializedName("currently") var currentWeather: CurrentWeatherRemoteEntity? = null,
    @SerializedName("daily") var forecastWeather: ForecastWeatherRemoteEntity? = null
)
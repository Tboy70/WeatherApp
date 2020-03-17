package com.tboy.data.entity.remote

import com.google.gson.annotations.SerializedName

data class ForecastWeatherRemoteEntity(
    @SerializedName("time") val time: Int? = null,
    @SerializedName("summary") val summary: String? = null,
    @SerializedName("icon") val icon: String? = null,
    @SerializedName("precipIntensity") val precipIntensity: Float? = null,
    @SerializedName("precipProbability") val precipProbability: Float? = null,
    @SerializedName("precipType") val precipType: Float? = null,
    @SerializedName("humidity") val humidity: Float? = null,
    @SerializedName("pressure") val pressure: Float? = null,
    @SerializedName("windSpeed") val windSpeed: Float? = null,
    @SerializedName("cloudCover") val cloudCover: Float? = null,
    @SerializedName("temperatureMin") val temperatureMin: Float? = null,
    @SerializedName("temperatureMax") val temperatureMax: Float? = null,
    @SerializedName("apparentTemperatureMin") val apparentTemperatureMin: Float? = null,
    @SerializedName("apparentTemperatureMax") val apparentTemperatureMax: Float? = null
)
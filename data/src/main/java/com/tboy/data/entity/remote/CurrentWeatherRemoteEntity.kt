package com.tboy.data.entity.remote

import com.google.gson.annotations.SerializedName

data class CurrentWeatherRemoteEntity(
    @SerializedName("time") val time: Int? = null,
    @SerializedName("summary") val summary: String? = null,
    @SerializedName("icon") val icon: String? = null,
    @SerializedName("precipIntensity") val precipIntensity: Double? = null,
    @SerializedName("precipProbability") val precipProbability: Double? = null,
    @SerializedName("temperature") val temperature: Double? = null,
    @SerializedName("humidity") val humidity: Double? = null,
    @SerializedName("apparentTemperature") val apparentTemperature: Double? = null,
    @SerializedName("pressure") val pressure: Double? = null,
    @SerializedName("windSpeed") val windSpeed: Double? = null,
    @SerializedName("cloudCover") val cloudCover: Double? = null
)
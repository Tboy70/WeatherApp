package com.tboy.data.entity.remote

import com.google.gson.annotations.SerializedName

data class DailyWeatherRemoteEntity (
    @SerializedName("time") val time: Int? = null,
    @SerializedName("summary") val summary: String? = null,
    @SerializedName("icon") val icon: String? = null,
    @SerializedName("precipIntensity") val precipIntensity: Double? = null,
    @SerializedName("precipProbability") val precipProbability: Double? = null,
    @SerializedName("precipType") val precipType: String? = null,
    @SerializedName("humidity") val humidity: Double? = null,
    @SerializedName("pressure") val pressure: Double? = null,
    @SerializedName("windSpeed") val windSpeed: Double? = null,
    @SerializedName("cloudCover") val cloudCover: Double? = null,
    @SerializedName("temperatureMin") val temperatureMin: Double? = null,
    @SerializedName("temperatureMax") val temperatureMax: Double? = null,
    @SerializedName("apparentTemperatureMin") val apparentTemperatureMin: Double? = null,
    @SerializedName("apparentTemperatureMax") val apparentTemperatureMax: Double? = null
)
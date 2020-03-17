package com.tboy.data.entity.remote

import com.google.gson.annotations.SerializedName

data class ForecastWeatherRemoteEntity(
    @SerializedName("summary") val generalSummary: String? = null,
    @SerializedName("icon") val generalIcon: String? = null,
    @SerializedName("data") val data: List<DailyWeatherRemoteEntity>? = emptyList()

)
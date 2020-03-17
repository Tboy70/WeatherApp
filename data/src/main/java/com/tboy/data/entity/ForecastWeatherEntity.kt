package com.tboy.data.entity

data class ForecastWeatherEntity(
    val generalSummary: String? = null,
    val generalIcon: String? = null,
    val data: List<DailyWeatherEntity>? = emptyList()
)
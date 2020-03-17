package com.tboy.domain.model

data class ForecastWeather(
    val generalSummary: String? = null,
    val generalIcon: String? = null,
    val data: List<DailyWeather>? = emptyList()
)
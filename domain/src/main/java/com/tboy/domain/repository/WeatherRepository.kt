package com.tboy.domain.repository

import com.tboy.domain.model.WeatherResult
import io.reactivex.Single

interface WeatherRepository {
    fun retrieveWeatherInformation(
        coordinates: List<Double>,
        refreshData: Boolean
    ): Single<WeatherResult>
}
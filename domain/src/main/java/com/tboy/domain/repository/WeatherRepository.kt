package com.tboy.domain.repository

import com.tboy.domain.model.WeatherResultEnvelope
import io.reactivex.Single

interface WeatherRepository {
    fun retrieveWeatherInformation(coordinates: List<Double>): Single<WeatherResultEnvelope>
}
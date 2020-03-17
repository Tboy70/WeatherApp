package com.tboy.data.manager.api

import com.tboy.data.entity.remote.WeatherResultEnvelopeRemoteEntity
import io.reactivex.Single

interface ApiManager {
    fun retrieveWeatherInformation(coordinates: List<Double>): Single<WeatherResultEnvelopeRemoteEntity>
}
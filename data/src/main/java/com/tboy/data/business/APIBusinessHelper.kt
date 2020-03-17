package com.tboy.data.business

import com.tboy.data.entity.WeatherResultEnvelopeEntity
import com.tboy.data.manager.api.ApiManager
import com.tboy.data.mapper.remote.WeatherResultEnvelopeRemoteEntityDataMapper
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class APIBusinessHelper @Inject constructor(
    private val apiManager: ApiManager,
    private val weatherResultEnvelopeRemoteEntityDataMapper: WeatherResultEnvelopeRemoteEntityDataMapper
) {
    fun retrieveWeatherInformation(coordinates: List<Double>): Single<WeatherResultEnvelopeEntity> {
        return apiManager.retrieveWeatherInformation(coordinates).map {
            weatherResultEnvelopeRemoteEntityDataMapper.transformToEntity(it)
        }
    }

}
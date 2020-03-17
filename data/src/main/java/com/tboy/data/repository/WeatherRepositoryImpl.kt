package com.tboy.data.repository

import com.tboy.data.business.APIBusinessHelper
import com.tboy.data.mapper.WeatherResultEnvelopeEntityDataMapper
import com.tboy.domain.model.WeatherResultEnvelope
import com.tboy.domain.repository.WeatherRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val apiBusinessHelper: APIBusinessHelper,
    private val weatherResultEnvelopeEntityDataMapper: WeatherResultEnvelopeEntityDataMapper
) : WeatherRepository {

    override fun retrieveWeatherInformation(coordinates: List<Double>): Single<WeatherResultEnvelope> {
        return Single.defer {
            apiBusinessHelper.retrieveWeatherInformation(coordinates).map {
                weatherResultEnvelopeEntityDataMapper.transformFromEntity(it)
            }
        }
    }

}
package com.tboy.data.repository

import com.tboy.data.business.APIBusinessHelper
import com.tboy.data.mapper.WeatherResultEntityDataMapper
import com.tboy.domain.model.WeatherResult
import com.tboy.domain.repository.WeatherRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val apiBusinessHelper: APIBusinessHelper,
    private val weatherResultEntityDataMapper: WeatherResultEntityDataMapper
) : WeatherRepository {

    override fun retrieveWeatherInformation(
        coordinates: List<Double>,
        refreshData: Boolean
    ): Single<WeatherResult> {
        return Single.defer {
            apiBusinessHelper.retrieveWeatherInformation(coordinates, refreshData).map {
                weatherResultEntityDataMapper.transformFromEntity(it)
            }
        }
    }

}
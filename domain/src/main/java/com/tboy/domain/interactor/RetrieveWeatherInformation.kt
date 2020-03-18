package com.tboy.domain.interactor

import com.tboy.domain.interactor.base.parametrized.SingleParametrizedUseCase
import com.tboy.domain.model.WeatherResult
import com.tboy.domain.repository.WeatherRepository
import io.reactivex.Single
import javax.inject.Inject

class RetrieveWeatherInformation @Inject constructor(
    private val weatherRepository: WeatherRepository
) : SingleParametrizedUseCase<WeatherResult, RetrieveWeatherInformation.Params>() {

    override fun build(params: Params): Single<WeatherResult> {
        return weatherRepository.retrieveWeatherInformation(params.coordinates, params.refreshData)
    }

    class Params(val coordinates: List<Double>, val refreshData: Boolean) {

        companion object {
            fun toRetrieve(
                coordinates: List<Double>,
                refreshData: Boolean
            ): Params {
                return Params(coordinates, refreshData)
            }
        }
    }
}
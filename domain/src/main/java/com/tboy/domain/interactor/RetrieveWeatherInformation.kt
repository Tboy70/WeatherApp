package com.tboy.domain.interactor

import com.tboy.domain.interactor.base.parametrized.SingleParametrizedUseCase
import com.tboy.domain.model.WeatherResultEnvelope
import com.tboy.domain.repository.WeatherRepository
import io.reactivex.Single
import javax.inject.Inject

class RetrieveWeatherInformation @Inject constructor(
    private val weatherRepository: WeatherRepository
) : SingleParametrizedUseCase<WeatherResultEnvelope, RetrieveWeatherInformation.Params>() {

    override fun build(params: Params): Single<WeatherResultEnvelope> {
        return weatherRepository.retrieveWeatherInformation(params.coordinates)
    }

    class Params(val coordinates: List<Double>) {

        companion object {
            fun toRetrieve(coordinates: List<Double>): Params {
                return Params(coordinates)
            }
        }
    }
}
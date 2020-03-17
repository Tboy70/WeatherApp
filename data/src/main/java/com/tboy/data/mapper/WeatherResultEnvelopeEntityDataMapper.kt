package com.tboy.data.mapper

import com.tboy.data.entity.WeatherResultEnvelopeEntity
import com.tboy.data.exception.DataMappingException
import com.tboy.domain.model.WeatherResultEnvelope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherResultEnvelopeEntityDataMapper @Inject constructor(
    private val currentWeatherEntityDataMapper: CurrentWeatherEntityDataMapper,
    private val forecastWeatherEntityDataMapper: ForecastWeatherEntityDataMapper
) {

    @Throws(DataMappingException::class)
    fun transformToEntity(weatherResultEnvelope: WeatherResultEnvelope): WeatherResultEnvelopeEntity {
        try {
            return WeatherResultEnvelopeEntity(
                latitude = weatherResultEnvelope.latitude,
                longitude = weatherResultEnvelope.longitude,
                currentWeather = weatherResultEnvelope.currentWeather?.let {
                    currentWeatherEntityDataMapper.transformToEntity(
                        it
                    )
                },
                forecastWeather = weatherResultEnvelope.forecastWeather?.let {
                    forecastWeatherEntityDataMapper.transformToEntity(
                        it
                    )
                } ?: emptyList()
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformToEntity(weatherResultEnvelopeList: List<WeatherResultEnvelope>) =
        weatherResultEnvelopeList.mapNotNull { weatherResultEnvelope ->
            try {
                transformToEntity(weatherResultEnvelope)
            } catch (e: DataMappingException) {
                null
            }
        }

    @Throws(DataMappingException::class)
    fun transformFromEntity(weatherResultEnvelopeEntity: WeatherResultEnvelopeEntity): WeatherResultEnvelope {
        try {
            return WeatherResultEnvelope(
                latitude = weatherResultEnvelopeEntity.latitude,
                longitude = weatherResultEnvelopeEntity.longitude,
                currentWeather = weatherResultEnvelopeEntity.currentWeather?.let {
                    currentWeatherEntityDataMapper.transformFromEntity(
                        it
                    )
                },
                forecastWeather = weatherResultEnvelopeEntity.forecastWeather?.let {
                    forecastWeatherEntityDataMapper.transformFromEntity(
                        it
                    )
                } ?: emptyList()
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformFromEntity(weatherResultEnvelopeEntityList: List<WeatherResultEnvelopeEntity>) =
        weatherResultEnvelopeEntityList.mapNotNull { weatherResultEnvelopeEntity ->
            try {
                transformFromEntity(weatherResultEnvelopeEntity)
            } catch (e: DataMappingException) {
                null
            }
        }
}
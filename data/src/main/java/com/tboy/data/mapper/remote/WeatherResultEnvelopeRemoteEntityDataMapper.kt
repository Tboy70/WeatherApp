package com.tboy.data.mapper.remote

import com.tboy.data.entity.WeatherResultEnvelopeEntity
import com.tboy.data.entity.remote.WeatherResultEnvelopeRemoteEntity
import com.tboy.data.exception.DataMappingException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherResultEnvelopeRemoteEntityDataMapper @Inject constructor(
    private val currentWeatherRemoteEntityDataMapper: CurrentWeatherRemoteEntityDataMapper,
    private val forecastWeatherRemoteEntityDataMapper: ForecastWeatherRemoteEntityDataMapper
) {

    @Throws(DataMappingException::class)
    fun transformToEntity(weatherResultEnvelopeRemoteEntity: WeatherResultEnvelopeRemoteEntity): WeatherResultEnvelopeEntity {
        try {
            return WeatherResultEnvelopeEntity(
                latitude = weatherResultEnvelopeRemoteEntity.latitude,
                longitude = weatherResultEnvelopeRemoteEntity.longitude,
                currentWeather = weatherResultEnvelopeRemoteEntity.currentWeather?.let {
                    currentWeatherRemoteEntityDataMapper.transformToEntity(
                        it
                    )
                },
                forecastWeather = weatherResultEnvelopeRemoteEntity.forecastWeather?.let {
                    forecastWeatherRemoteEntityDataMapper.transformToEntity(
                        it
                    )
                } ?: emptyList()
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformToEntity(weatherResultEnvelopeRemoteEntityList: List<WeatherResultEnvelopeRemoteEntity>) =
        weatherResultEnvelopeRemoteEntityList.mapNotNull { weatherResultEnvelopeRemoteEntity ->
            try {
                transformToEntity(weatherResultEnvelopeRemoteEntity)
            } catch (e: DataMappingException) {
                null
            }
        }

    @Throws(DataMappingException::class)
    fun transformFromEntity(weatherResultEnvelopeEntity: WeatherResultEnvelopeEntity): WeatherResultEnvelopeRemoteEntity {
        try {
            return WeatherResultEnvelopeRemoteEntity(
                latitude = weatherResultEnvelopeEntity.latitude,
                longitude = weatherResultEnvelopeEntity.longitude,
                currentWeather = weatherResultEnvelopeEntity.currentWeather?.let {
                    currentWeatherRemoteEntityDataMapper.transformFromEntity(
                        it
                    )
                },
                forecastWeather = weatherResultEnvelopeEntity.forecastWeather?.let {
                    forecastWeatherRemoteEntityDataMapper.transformFromEntity(
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
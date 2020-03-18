package com.tboy.data.mapper.remote

import com.tboy.data.entity.WeatherResultEntity
import com.tboy.data.entity.remote.WeatherResultRemoteEntity
import com.tboy.data.exception.DataMappingException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherResultRemoteEntityDataMapper @Inject constructor(
    private val currentWeatherRemoteEntityDataMapper: CurrentWeatherRemoteEntityDataMapper,
    private val forecastWeatherRemoteEntityDataMapper: ForecastWeatherRemoteEntityDataMapper
) {

    @Throws(DataMappingException::class)
    fun transformToEntity(weatherResultRemoteEntity: WeatherResultRemoteEntity): WeatherResultEntity {
        try {
            return WeatherResultEntity(
                timezone = weatherResultRemoteEntity.timezone,
                latitude = weatherResultRemoteEntity.latitude,
                longitude = weatherResultRemoteEntity.longitude,
                currentWeather = weatherResultRemoteEntity.currentWeather?.let {
                    currentWeatherRemoteEntityDataMapper.transformToEntity(
                        it
                    )
                },
                forecastWeather = weatherResultRemoteEntity.forecastWeather?.let {
                    forecastWeatherRemoteEntityDataMapper.transformToEntity(
                        it
                    )
                }
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformToEntity(weatherResultRemoteEntityList: List<WeatherResultRemoteEntity>) =
        weatherResultRemoteEntityList.mapNotNull { weatherResultRemoteEntity ->
            try {
                transformToEntity(weatherResultRemoteEntity)
            } catch (e: DataMappingException) {
                null
            }
        }

    @Throws(DataMappingException::class)
    fun transformFromEntity(weatherResultEntity: WeatherResultEntity): WeatherResultRemoteEntity {
        try {
            return WeatherResultRemoteEntity(
                timezone = weatherResultEntity.timezone,
                latitude = weatherResultEntity.latitude,
                longitude = weatherResultEntity.longitude,
                currentWeather = weatherResultEntity.currentWeather?.let {
                    currentWeatherRemoteEntityDataMapper.transformFromEntity(
                        it
                    )
                },
                forecastWeather =
                weatherResultEntity.forecastWeather?.let {
                    forecastWeatherRemoteEntityDataMapper.transformFromEntity(
                        it
                    )
                }
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformFromEntity(weatherResultEntityList: List<WeatherResultEntity>) =
        weatherResultEntityList.mapNotNull { weatherResultEntity ->
            try {
                transformFromEntity(weatherResultEntity)
            } catch (e: DataMappingException) {
                null
            }
        }
}
package com.tboy.data.mapper

import com.tboy.data.entity.WeatherResultEntity
import com.tboy.data.exception.DataMappingException
import com.tboy.domain.model.WeatherResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherResultEntityDataMapper @Inject constructor(
    private val currentWeatherEntityDataMapper: CurrentWeatherEntityDataMapper,
    private val forecastWeatherEntityDataMapper: ForecastWeatherEntityDataMapper
) {

    @Throws(DataMappingException::class)
    fun transformToEntity(weatherResult: WeatherResult): WeatherResultEntity {
        try {
            return WeatherResultEntity(
                timezone = weatherResult.timezone,
                latitude = weatherResult.latitude,
                longitude = weatherResult.longitude,
                currentWeather = weatherResult.currentWeather?.let {
                    currentWeatherEntityDataMapper.transformToEntity(
                        it
                    )
                },
                forecastWeather = weatherResult.forecastWeather?.let {
                    forecastWeatherEntityDataMapper.transformToEntity(
                        it
                    )
                }

            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformToEntity(weatherResultList: List<WeatherResult>) =
        weatherResultList.mapNotNull { weatherResult ->
            try {
                transformToEntity(weatherResult)
            } catch (e: DataMappingException) {
                null
            }
        }

    @Throws(DataMappingException::class)
    fun transformFromEntity(weatherResultEntity: WeatherResultEntity): WeatherResult {
        try {
            return WeatherResult(
                timezone = weatherResultEntity.timezone,
                latitude = weatherResultEntity.latitude,
                longitude = weatherResultEntity.longitude,
                currentWeather = weatherResultEntity.currentWeather?.let {
                    currentWeatherEntityDataMapper.transformFromEntity(
                        it
                    )
                },
                forecastWeather = weatherResultEntity.forecastWeather?.let {
                    forecastWeatherEntityDataMapper.transformFromEntity(
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
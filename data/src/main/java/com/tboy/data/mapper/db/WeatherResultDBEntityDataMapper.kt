package com.tboy.data.mapper.db

import com.tboy.data.db.entity.WeatherResultDBEntity
import com.tboy.data.entity.WeatherResultEntity
import com.tboy.data.exception.DataMappingException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherResultDBEntityDataMapper @Inject constructor(
    private val currentWeatherDBEntityDataMapper: CurrentWeatherDBEntityDataMapper,
    private val forecastWeatherDBEntityDataMapper: ForecastWeatherDBEntityDataMapper
) {

    fun transformFromDB(weatherResultDBEntityList: List<WeatherResultDBEntity>) =
        weatherResultDBEntityList.mapNotNull { weatherResultDBEntity ->
            try {
                transformFromDB(weatherResultDBEntity)
            } catch (e: DataMappingException) {
                null
            }
        }

    @Throws(DataMappingException::class)
    fun transformFromDB(weatherResultDBEntity: WeatherResultDBEntity): WeatherResultEntity {
        try {
            return WeatherResultEntity(
                timezone = weatherResultDBEntity.timezone,
                latitude = weatherResultDBEntity.latitude,
                longitude = weatherResultDBEntity.longitude,
                currentWeather = weatherResultDBEntity.currentWeather?.let {
                    currentWeatherDBEntityDataMapper.transformFromDB(
                        it
                    )
                },
                forecastWeather = weatherResultDBEntity.forecastWeather?.let {
                    forecastWeatherDBEntityDataMapper.transformFromDB(
                        it
                    )
                }
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformToDB(weatherResultEntityList: List<WeatherResultEntity>) =
        weatherResultEntityList.mapNotNull { weatherResultEntity ->
            try {
                transformToDB(weatherResultEntity)
            } catch (e: DataMappingException) {
                null
            }
        }

    @Throws(DataMappingException::class)
    fun transformToDB(weatherResultEntity: WeatherResultEntity): WeatherResultDBEntity {
        try {
            return WeatherResultDBEntity(
                timezone = weatherResultEntity.timezone,
                latitude = weatherResultEntity.latitude,
                longitude = weatherResultEntity.longitude,
                currentWeather = weatherResultEntity.currentWeather?.let {
                    currentWeatherDBEntityDataMapper.transformToDB(
                        it
                    )
                },
                forecastWeather = weatherResultEntity.forecastWeather?.let {
                    forecastWeatherDBEntityDataMapper.transformToDB(
                        it
                    )
                }
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }
}
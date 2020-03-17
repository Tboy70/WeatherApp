package com.tboy.data.mapper

import com.tboy.data.entity.CurrentWeatherEntity
import com.tboy.data.exception.DataMappingException
import com.tboy.domain.model.CurrentWeather
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrentWeatherEntityDataMapper @Inject constructor() {

    @Throws(DataMappingException::class)
    fun transformFromEntity(currentWeatherEntity: CurrentWeatherEntity): CurrentWeather {
        try {
            return CurrentWeather(
                time = currentWeatherEntity.time,
                summary = currentWeatherEntity.summary,
                icon = currentWeatherEntity.icon,
                precipIntensity = currentWeatherEntity.precipIntensity,
                precipProbability = currentWeatherEntity.precipProbability,
                temperature = currentWeatherEntity.temperature,
                humidity = currentWeatherEntity.humidity,
                apparentTemperature = currentWeatherEntity.apparentTemperature,
                pressure = currentWeatherEntity.pressure,
                windSpeed = currentWeatherEntity.windSpeed,
                cloudCover = currentWeatherEntity.cloudCover
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformFromEntity(currentWeatherEntityList: List<CurrentWeatherEntity>) =
        currentWeatherEntityList.mapNotNull { currentWeatherEntity ->
            try {
                transformFromEntity(currentWeatherEntity)
            } catch (e: DataMappingException) {
                null
            }
        }

    @Throws(DataMappingException::class)
    fun transformToEntity(currentWeather: CurrentWeather): CurrentWeatherEntity {
        try {
            return CurrentWeatherEntity(
                time = currentWeather.time,
                summary = currentWeather.summary,
                icon = currentWeather.icon,
                precipIntensity = currentWeather.precipIntensity,
                precipProbability = currentWeather.precipProbability,
                temperature = currentWeather.temperature,
                humidity = currentWeather.humidity,
                apparentTemperature = currentWeather.apparentTemperature,
                pressure = currentWeather.pressure,
                windSpeed = currentWeather.windSpeed,
                cloudCover = currentWeather.cloudCover
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformToEntity(currentWeatherList: List<CurrentWeather>) =
        currentWeatherList.mapNotNull { currentWeather ->
            try {
                transformToEntity(currentWeather)
            } catch (e: DataMappingException) {
                null
            }
        }
}
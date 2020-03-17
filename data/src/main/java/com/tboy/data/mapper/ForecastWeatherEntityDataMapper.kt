package com.tboy.data.mapper

import com.tboy.data.entity.ForecastWeatherEntity
import com.tboy.data.exception.DataMappingException
import com.tboy.domain.model.ForecastWeather
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ForecastWeatherEntityDataMapper @Inject constructor() {

    @Throws(DataMappingException::class)
    fun transformFromEntity(forecastWeatherEntity: ForecastWeatherEntity): ForecastWeather {
        try {
            return ForecastWeather(
                time = forecastWeatherEntity.time,
                summary = forecastWeatherEntity.summary,
                icon = forecastWeatherEntity.icon,
                precipIntensity = forecastWeatherEntity.precipIntensity,
                precipProbability = forecastWeatherEntity.precipProbability,
                precipType = forecastWeatherEntity.precipType,
                humidity = forecastWeatherEntity.humidity,
                pressure = forecastWeatherEntity.pressure,
                windSpeed = forecastWeatherEntity.windSpeed,
                cloudCover = forecastWeatherEntity.cloudCover,
                temperatureMin = forecastWeatherEntity.temperatureMin,
                temperatureMax = forecastWeatherEntity.temperatureMax,
                apparentTemperatureMin = forecastWeatherEntity.apparentTemperatureMin,
                apparentTemperatureMax = forecastWeatherEntity.apparentTemperatureMax
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformFromEntity(forecastWeatherEntityList: List<ForecastWeatherEntity>) =
        forecastWeatherEntityList.mapNotNull { forecastWeatherEntity ->
            try {
                transformFromEntity(forecastWeatherEntity)
            } catch (e: DataMappingException) {
                null
            }
        }

    @Throws(DataMappingException::class)
    fun transformToEntity(forecastWeather: ForecastWeather): ForecastWeatherEntity {
        try {
            return ForecastWeatherEntity(
                time = forecastWeather.time,
                summary = forecastWeather.summary,
                icon = forecastWeather.icon,
                precipIntensity = forecastWeather.precipIntensity,
                precipProbability = forecastWeather.precipProbability,
                precipType = forecastWeather.precipType,
                humidity = forecastWeather.humidity,
                pressure = forecastWeather.pressure,
                windSpeed = forecastWeather.windSpeed,
                cloudCover = forecastWeather.cloudCover,
                temperatureMin = forecastWeather.temperatureMin,
                temperatureMax = forecastWeather.temperatureMax,
                apparentTemperatureMin = forecastWeather.apparentTemperatureMin,
                apparentTemperatureMax = forecastWeather.apparentTemperatureMax
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformToEntity(forecastWeatherList: List<ForecastWeather>) =
        forecastWeatherList.mapNotNull { forecastWeather ->
            try {
                transformToEntity(forecastWeather)
            } catch (e: DataMappingException) {
                null
            }
        }
}
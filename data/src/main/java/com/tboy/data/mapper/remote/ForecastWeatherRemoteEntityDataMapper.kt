package com.tboy.data.mapper.remote

import com.tboy.data.entity.ForecastWeatherEntity
import com.tboy.data.entity.remote.ForecastWeatherRemoteEntity
import com.tboy.data.exception.DataMappingException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ForecastWeatherRemoteEntityDataMapper @Inject constructor() {

    @Throws(DataMappingException::class)
    fun transformFromEntity(forecastWeatherEntity: ForecastWeatherEntity): ForecastWeatherRemoteEntity {
        try {
            return ForecastWeatherRemoteEntity(
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
    fun transformToEntity(forecastWeatherRemoteEntity: ForecastWeatherRemoteEntity): ForecastWeatherEntity {
        try {
            return ForecastWeatherEntity(
                time = forecastWeatherRemoteEntity.time,
                summary = forecastWeatherRemoteEntity.summary,
                icon = forecastWeatherRemoteEntity.icon,
                precipIntensity = forecastWeatherRemoteEntity.precipIntensity,
                precipProbability = forecastWeatherRemoteEntity.precipProbability,
                precipType = forecastWeatherRemoteEntity.precipType,
                humidity = forecastWeatherRemoteEntity.humidity,
                pressure = forecastWeatherRemoteEntity.pressure,
                windSpeed = forecastWeatherRemoteEntity.windSpeed,
                cloudCover = forecastWeatherRemoteEntity.cloudCover,
                temperatureMin = forecastWeatherRemoteEntity.temperatureMin,
                temperatureMax = forecastWeatherRemoteEntity.temperatureMax,
                apparentTemperatureMin = forecastWeatherRemoteEntity.apparentTemperatureMin,
                apparentTemperatureMax = forecastWeatherRemoteEntity.apparentTemperatureMax
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformToEntity(forecastWeatherRemoteEntityList: List<ForecastWeatherRemoteEntity>) =
        forecastWeatherRemoteEntityList.mapNotNull { forecastWeatherRemoteEntity ->
            try {
                transformToEntity(forecastWeatherRemoteEntity)
            } catch (e: DataMappingException) {
                null
            }
        }
}
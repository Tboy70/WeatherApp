package com.tboy.data.mapper

import com.tboy.data.entity.DailyWeatherEntity
import com.tboy.data.exception.DataMappingException
import com.tboy.domain.model.DailyWeather
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DailyWeatherEntityDataMapper @Inject constructor() {

    @Throws(DataMappingException::class)
    fun transformFromEntity(dailyWeatherEntity: DailyWeatherEntity): DailyWeather {
        try {
            return DailyWeather(
                time = dailyWeatherEntity.time,
                summary = dailyWeatherEntity.summary,
                icon = dailyWeatherEntity.icon,
                precipIntensity = dailyWeatherEntity.precipIntensity,
                precipProbability = dailyWeatherEntity.precipProbability,
                precipType = dailyWeatherEntity.precipType,
                humidity = dailyWeatherEntity.humidity,
                pressure = dailyWeatherEntity.pressure,
                windSpeed = dailyWeatherEntity.windSpeed,
                cloudCover = dailyWeatherEntity.cloudCover,
                temperatureMin = dailyWeatherEntity.temperatureMin,
                temperatureMax = dailyWeatherEntity.temperatureMax,
                apparentTemperatureMin = dailyWeatherEntity.apparentTemperatureMin,
                apparentTemperatureMax = dailyWeatherEntity.apparentTemperatureMax
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformFromEntity(dailyWeatherEntityList: List<DailyWeatherEntity>) =
        dailyWeatherEntityList.mapNotNull { dailyWeatherEntity ->
            try {
                transformFromEntity(dailyWeatherEntity)
            } catch (e: DataMappingException) {
                null
            }
        }

    @Throws(DataMappingException::class)
    fun transformToEntity(dailyWeather: DailyWeather): DailyWeatherEntity {
        try {
            return DailyWeatherEntity(
                time = dailyWeather.time,
                summary = dailyWeather.summary,
                icon = dailyWeather.icon,
                precipIntensity = dailyWeather.precipIntensity,
                precipProbability = dailyWeather.precipProbability,
                precipType = dailyWeather.precipType,
                humidity = dailyWeather.humidity,
                pressure = dailyWeather.pressure,
                windSpeed = dailyWeather.windSpeed,
                cloudCover = dailyWeather.cloudCover,
                temperatureMin = dailyWeather.temperatureMin,
                temperatureMax = dailyWeather.temperatureMax,
                apparentTemperatureMin = dailyWeather.apparentTemperatureMin,
                apparentTemperatureMax = dailyWeather.apparentTemperatureMax
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformToEntity(dailyWeatherList: List<DailyWeather>) =
        dailyWeatherList.mapNotNull { dailyWeather ->
            try {
                transformToEntity(dailyWeather)
            } catch (e: DataMappingException) {
                null
            }
        }
}
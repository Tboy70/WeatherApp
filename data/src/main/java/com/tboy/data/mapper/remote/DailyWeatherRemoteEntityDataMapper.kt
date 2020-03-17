package com.tboy.data.mapper.remote

import com.tboy.data.entity.DailyWeatherEntity
import com.tboy.data.entity.remote.DailyWeatherRemoteEntity
import com.tboy.data.exception.DataMappingException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DailyWeatherRemoteEntityDataMapper @Inject constructor() {

    @Throws(DataMappingException::class)
    fun transformFromEntity(dailyWeatherEntity: DailyWeatherEntity): DailyWeatherRemoteEntity {
        try {
            return DailyWeatherRemoteEntity(
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
    fun transformToEntity(dailyWeatherRemoteEntity: DailyWeatherRemoteEntity): DailyWeatherEntity {
        try {
            return DailyWeatherEntity(
                time = dailyWeatherRemoteEntity.time,
                summary = dailyWeatherRemoteEntity.summary,
                icon = dailyWeatherRemoteEntity.icon,
                precipIntensity = dailyWeatherRemoteEntity.precipIntensity,
                precipProbability = dailyWeatherRemoteEntity.precipProbability,
                precipType = dailyWeatherRemoteEntity.precipType,
                humidity = dailyWeatherRemoteEntity.humidity,
                pressure = dailyWeatherRemoteEntity.pressure,
                windSpeed = dailyWeatherRemoteEntity.windSpeed,
                cloudCover = dailyWeatherRemoteEntity.cloudCover,
                temperatureMin = dailyWeatherRemoteEntity.temperatureMin,
                temperatureMax = dailyWeatherRemoteEntity.temperatureMax,
                apparentTemperatureMin = dailyWeatherRemoteEntity.apparentTemperatureMin,
                apparentTemperatureMax = dailyWeatherRemoteEntity.apparentTemperatureMax
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformToEntity(dailyWeatherRemoteEntityList: List<DailyWeatherRemoteEntity>) =
        dailyWeatherRemoteEntityList.mapNotNull { dailyWeatherRemoteEntity ->
            try {
                transformToEntity(dailyWeatherRemoteEntity)
            } catch (e: DataMappingException) {
                null
            }
        }
}
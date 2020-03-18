package com.tboy.data.mapper.db

import com.tboy.data.db.entity.DailyWeatherDBEntity
import com.tboy.data.entity.DailyWeatherEntity
import com.tboy.data.exception.DataMappingException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DailyWeatherDBEntityDataMapper @Inject constructor(
) {

    fun transformFromDB(dailyWeatherDBEntityList: List<DailyWeatherDBEntity>) =
        dailyWeatherDBEntityList.mapNotNull { dailyWeatherDBEntity ->
            try {
                transformFromDB(dailyWeatherDBEntity)
            } catch (e: DataMappingException) {
                null
            }
        }

    @Throws(DataMappingException::class)
    fun transformFromDB(dailyWeatherDBEntity: DailyWeatherDBEntity): DailyWeatherEntity {
        try {
            return DailyWeatherEntity(
                time = dailyWeatherDBEntity.time,
                summary = dailyWeatherDBEntity.summary,
                icon = dailyWeatherDBEntity.icon,
                precipIntensity = dailyWeatherDBEntity.precipIntensity,
                precipProbability = dailyWeatherDBEntity.precipProbability,
                precipType = dailyWeatherDBEntity.precipType,
                humidity = dailyWeatherDBEntity.humidity,
                pressure = dailyWeatherDBEntity.pressure,
                windSpeed = dailyWeatherDBEntity.windSpeed,
                cloudCover = dailyWeatherDBEntity.cloudCover,
                temperatureMin = dailyWeatherDBEntity.temperatureMin,
                temperatureMax = dailyWeatherDBEntity.temperatureMax,
                apparentTemperatureMin = dailyWeatherDBEntity.apparentTemperatureMin,
                apparentTemperatureMax = dailyWeatherDBEntity.apparentTemperatureMax
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformToDB(dailyWeatherEntityList: List<DailyWeatherEntity>) =
        dailyWeatherEntityList.mapNotNull { dailyWeatherEntity ->
            try {
                transformToDB(dailyWeatherEntity)
            } catch (e: DataMappingException) {
                null
            }
        }

    @Throws(DataMappingException::class)
    fun transformToDB(dailyWeatherEntity: DailyWeatherEntity): DailyWeatherDBEntity {
        try {
            return DailyWeatherDBEntity(
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
}
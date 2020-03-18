package com.tboy.data.mapper.db

import com.tboy.data.db.entity.CurrentWeatherDBEntity
import com.tboy.data.entity.CurrentWeatherEntity
import com.tboy.data.exception.DataMappingException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrentWeatherDBEntityDataMapper @Inject constructor(
) {

    fun transformFromDB(currentWeatherDBEntityList: List<CurrentWeatherDBEntity>) =
        currentWeatherDBEntityList.mapNotNull { currentWeatherDBEntity ->
            try {
                transformFromDB(currentWeatherDBEntity)
            } catch (e: DataMappingException) {
                null
            }
        }

    @Throws(DataMappingException::class)
    fun transformFromDB(currentWeatherDBEntity: CurrentWeatherDBEntity): CurrentWeatherEntity {
        try {
            return CurrentWeatherEntity(
                time = currentWeatherDBEntity.time,
                summary = currentWeatherDBEntity.summary,
                icon = currentWeatherDBEntity.icon,
                precipIntensity = currentWeatherDBEntity.precipIntensity,
                precipProbability = currentWeatherDBEntity.precipProbability,
                temperature = currentWeatherDBEntity.temperature,
                humidity = currentWeatherDBEntity.humidity,
                apparentTemperature = currentWeatherDBEntity.apparentTemperature,
                pressure = currentWeatherDBEntity.pressure,
                windSpeed = currentWeatherDBEntity.windSpeed,
                cloudCover = currentWeatherDBEntity.cloudCover
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformToDB(currentWeatherEntityList: List<CurrentWeatherEntity>) =
        currentWeatherEntityList.mapNotNull { currentWeatherEntity ->
            try {
                transformToDB(currentWeatherEntity)
            } catch (e: DataMappingException) {
                null
            }
        }

    @Throws(DataMappingException::class)
    fun transformToDB(currentWeatherEntity: CurrentWeatherEntity): CurrentWeatherDBEntity {
        try {
            return CurrentWeatherDBEntity(
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
}
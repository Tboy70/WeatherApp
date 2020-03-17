package com.tboy.data.mapper.remote

import com.tboy.data.entity.CurrentWeatherEntity
import com.tboy.data.entity.remote.CurrentWeatherRemoteEntity
import com.tboy.data.exception.DataMappingException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrentWeatherRemoteEntityDataMapper @Inject constructor() {

    @Throws(DataMappingException::class)
    fun transformFromEntity(currentWeatherEntity: CurrentWeatherEntity): CurrentWeatherRemoteEntity {
        try {
            return CurrentWeatherRemoteEntity(
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
    fun transformToEntity(currentWeatherRemoteEntity: CurrentWeatherRemoteEntity): CurrentWeatherEntity {
        try {
            return CurrentWeatherEntity(
                time = currentWeatherRemoteEntity.time,
                summary = currentWeatherRemoteEntity.summary,
                icon = currentWeatherRemoteEntity.icon,
                precipIntensity = currentWeatherRemoteEntity.precipIntensity,
                precipProbability = currentWeatherRemoteEntity.precipProbability,
                temperature = currentWeatherRemoteEntity.temperature,
                humidity = currentWeatherRemoteEntity.humidity,
                apparentTemperature = currentWeatherRemoteEntity.apparentTemperature,
                pressure = currentWeatherRemoteEntity.pressure,
                windSpeed = currentWeatherRemoteEntity.windSpeed,
                cloudCover = currentWeatherRemoteEntity.cloudCover
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformToEntity(currentWeatherRemoteEntityList: List<CurrentWeatherRemoteEntity>) =
        currentWeatherRemoteEntityList.mapNotNull { currentWeatherRemoteEntity ->
            try {
                transformToEntity(currentWeatherRemoteEntity)
            } catch (e: DataMappingException) {
                null
            }
        }
}
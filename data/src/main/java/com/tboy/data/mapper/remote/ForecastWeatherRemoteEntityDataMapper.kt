package com.tboy.data.mapper.remote

import com.tboy.data.entity.ForecastWeatherEntity
import com.tboy.data.entity.remote.ForecastWeatherRemoteEntity
import com.tboy.data.exception.DataMappingException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ForecastWeatherRemoteEntityDataMapper @Inject constructor(
    private val dailyWeatherRemoteEntityDataMapper: DailyWeatherRemoteEntityDataMapper
) {

    @Throws(DataMappingException::class)
    fun transformFromEntity(forecastWeatherEntity: ForecastWeatherEntity): ForecastWeatherRemoteEntity {
        try {
            return ForecastWeatherRemoteEntity(
                generalSummary = forecastWeatherEntity.generalSummary,
                generalIcon = forecastWeatherEntity.generalIcon,
                data = forecastWeatherEntity.data?.let {
                    dailyWeatherRemoteEntityDataMapper.transformFromEntity(
                        it
                    )
                }
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
                generalSummary = forecastWeatherRemoteEntity.generalSummary,
                generalIcon = forecastWeatherRemoteEntity.generalIcon,
                data = forecastWeatherRemoteEntity.data?.let {
                    dailyWeatherRemoteEntityDataMapper.transformToEntity(
                        it
                    )
                }
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
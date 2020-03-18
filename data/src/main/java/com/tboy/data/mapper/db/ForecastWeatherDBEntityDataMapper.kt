package com.tboy.data.mapper.db

import com.tboy.data.db.entity.ForecastWeatherDBEntity
import com.tboy.data.entity.ForecastWeatherEntity
import com.tboy.data.exception.DataMappingException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ForecastWeatherDBEntityDataMapper @Inject constructor(
    private val dailyWeatherDBEntityDataMapper: DailyWeatherDBEntityDataMapper
) {

    fun transformFromDB(forecastWeatherDBEntityList: List<ForecastWeatherDBEntity>) =
        forecastWeatherDBEntityList.mapNotNull { forecastWeatherDBEntity ->
            try {
                transformFromDB(forecastWeatherDBEntity)
            } catch (e: DataMappingException) {
                null
            }
        }

    @Throws(DataMappingException::class)
    fun transformFromDB(forecastWeatherDBEntity: ForecastWeatherDBEntity): ForecastWeatherEntity {
        try {
            return ForecastWeatherEntity(
                generalSummary = forecastWeatherDBEntity.generalSummary,
                generalIcon = forecastWeatherDBEntity.generalIcon,
                data = forecastWeatherDBEntity.data?.let {
                    dailyWeatherDBEntityDataMapper.transformFromDB(
                        it
                    )
                }
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }

    fun transformToDB(forecastWeatherEntityList: List<ForecastWeatherEntity>) =
        forecastWeatherEntityList.mapNotNull { forecastWeatherEntity ->
            try {
                transformToDB(forecastWeatherEntity)
            } catch (e: DataMappingException) {
                null
            }
        }

    @Throws(DataMappingException::class)
    fun transformToDB(forecastWeatherEntity: ForecastWeatherEntity): ForecastWeatherDBEntity {
        try {
            return ForecastWeatherDBEntity(
                generalSummary = forecastWeatherEntity.generalSummary,
                generalIcon = forecastWeatherEntity.generalIcon,
                data = forecastWeatherEntity.data?.let {
                    dailyWeatherDBEntityDataMapper.transformToDB(
                        it
                    )
                }
            )
        } catch (e: Exception) {
            throw DataMappingException()
        }
    }
}
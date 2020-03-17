package com.tboy.data.mapper

import com.tboy.data.entity.ForecastWeatherEntity
import com.tboy.data.exception.DataMappingException
import com.tboy.domain.model.ForecastWeather
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ForecastWeatherEntityDataMapper @Inject constructor(
    private val dailyWeatherEntityDataMapper: DailyWeatherEntityDataMapper
) {

    @Throws(DataMappingException::class)
    fun transformFromEntity(forecastWeatherEntity: ForecastWeatherEntity): ForecastWeather {
        try {
            return ForecastWeather(
                generalSummary = forecastWeatherEntity.generalSummary,
                generalIcon = forecastWeatherEntity.generalIcon,
                data = forecastWeatherEntity.data?.let {
                    dailyWeatherEntityDataMapper.transformFromEntity(
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
    fun transformToEntity(forecastWeather: ForecastWeather): ForecastWeatherEntity {
        try {
            return ForecastWeatherEntity(
                generalSummary = forecastWeather.generalSummary,
                generalIcon = forecastWeather.generalIcon,
                data = forecastWeather.data?.let {
                    dailyWeatherEntityDataMapper.transformToEntity(
                        it
                    )
                }
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
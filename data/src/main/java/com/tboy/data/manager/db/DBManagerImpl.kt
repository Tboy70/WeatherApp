package com.tboy.data.manager.db

import com.tboy.data.db.dao.WeatherResultDao
import com.tboy.data.db.entity.WeatherResultDBEntity
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DBManagerImpl @Inject constructor(
    private val weatherResultDao: WeatherResultDao
) : DBManager {

    override fun insertWeatherResult(weatherResultDBEntity: WeatherResultDBEntity) {
        weatherResultDao.insert(weatherResultDBEntity)
    }

    override fun retrieveInformation(coordinates: List<Double>): Single<WeatherResultDBEntity> {
        return weatherResultDao.get(coordinates[0], coordinates[1])
    }
}
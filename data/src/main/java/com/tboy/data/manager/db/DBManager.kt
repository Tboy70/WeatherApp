package com.tboy.data.manager.db

import com.tboy.data.db.entity.WeatherResultDBEntity
import io.reactivex.Single


interface DBManager {
    fun insertWeatherResult(weatherResultDBEntity: WeatherResultDBEntity)
    fun retrieveInformation(coordinates: List<Double>): Single<WeatherResultDBEntity>
}
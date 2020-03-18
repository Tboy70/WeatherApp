package com.tboy.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tboy.data.db.converter.CurrentWeatherConverter
import com.tboy.data.db.converter.DailyWeatherConverter
import com.tboy.data.db.converter.ForecastWeatherConverter
import com.tboy.data.db.dao.WeatherResultDao
import com.tboy.data.db.entity.CurrentWeatherDBEntity
import com.tboy.data.db.entity.DailyWeatherDBEntity
import com.tboy.data.db.entity.ForecastWeatherDBEntity
import com.tboy.data.db.entity.WeatherResultDBEntity

@Database(
    version = 1,
    entities = [
        WeatherResultDBEntity::class,
        CurrentWeatherDBEntity::class,
        ForecastWeatherDBEntity::class,
        DailyWeatherDBEntity::class
    ]
)

@TypeConverters(
    CurrentWeatherConverter::class,
    ForecastWeatherConverter::class,
    DailyWeatherConverter::class
)
abstract class WeatherAppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "WeatherAppDataDb"
    }

    abstract fun getWeatherResultDao(): WeatherResultDao

}
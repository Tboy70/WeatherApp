package com.tboy.data.di.module

import android.content.Context
import androidx.room.Room
import com.tboy.data.db.WeatherAppDatabase
import com.tboy.data.db.dao.WeatherResultDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Singleton
    @Provides
    internal fun provideDatabase(context: Context): WeatherAppDatabase {
        return Room.databaseBuilder(
            context,
            WeatherAppDatabase::class.java,
            WeatherAppDatabase.DATABASE_NAME
        )
            .build()
    }

    @Singleton
    @Provides
    internal fun provideWeatherResultDao(db: WeatherAppDatabase): WeatherResultDao {
        return db.getWeatherResultDao()
    }
}
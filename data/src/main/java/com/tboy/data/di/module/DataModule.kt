package com.tboy.data.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tboy.data.executor.JobExecutor
import com.tboy.data.repository.WeatherRepositoryImpl
import com.tboy.domain.executor.ThreadExecutor
import com.tboy.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun jobExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

    @Provides
    @Singleton
    fun gson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun weatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository =
        weatherRepositoryImpl
}
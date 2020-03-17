package com.tboy.data.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tboy.data.executor.JobExecutor
import com.tboy.domain.executor.ThreadExecutor
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
}
package com.tboy.weatherapp.di.module

import android.app.Application
import android.content.Context
import com.tboy.weatherapp.di.annotation.PerApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    @PerApplication
    fun context(application: Application): Context = application
}
package com.tboy.weatherapp.di.module

import com.tboy.weatherapp.MainActivity
import com.tboy.weatherapp.di.annotation.PerActivity
import com.tboy.weatherapp.di.module.activity.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivityInjector(): MainActivity
}
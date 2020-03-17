package com.tboy.weatherapp.di.module.activity

import com.tboy.weatherapp.activity.MainActivity
import com.tboy.weatherapp.activity.BaseActivity
import com.tboy.weatherapp.di.annotation.PerActivity
import com.tboy.weatherapp.di.annotation.PerFragment
import com.tboy.weatherapp.fragment.MainWeatherFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [BaseActivityModule::class])
abstract class MainActivityModule {

    @PerActivity
    @Binds
    abstract fun bindBaseActivity(mainActivity: MainActivity): BaseActivity

    @PerFragment
    @ContributesAndroidInjector
    abstract fun mainWeatherFragmentInjector(): MainWeatherFragment
}
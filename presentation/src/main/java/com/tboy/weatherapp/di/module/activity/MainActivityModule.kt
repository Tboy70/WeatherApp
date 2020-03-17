package com.tboy.weatherapp.di.module.activity

import com.tboy.weatherapp.activity.MainActivity
import com.tboy.weatherapp.activity.BaseActivity
import com.tboy.weatherapp.di.annotation.PerActivity
import dagger.Binds
import dagger.Module

@Module(includes = [BaseActivityModule::class])
abstract class MainActivityModule {

    @PerActivity
    @Binds
    abstract fun bindBaseActivity(mainActivity: MainActivity): BaseActivity
}
package com.tboy.weatherapp

import android.app.Activity
import android.app.Application
import com.tboy.data.di.DaggerDataComponent
import com.tboy.weatherapp.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class WeatherAppApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder()
            .application(this)
            .dataComponent(
                DaggerDataComponent.builder().context(this).build()
            )
            .build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

}
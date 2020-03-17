package com.tboy.weatherapp.di.component

import android.app.Application
import com.tboy.data.di.DataComponent
import com.tboy.weatherapp.WeatherAppApplication
import com.tboy.weatherapp.di.annotation.PerApplication
import com.tboy.weatherapp.di.module.ActivityInjectorModule
import com.tboy.weatherapp.di.module.ApplicationModule
import com.tboy.weatherapp.di.module.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        ActivityInjectorModule::class,
        ViewModelModule::class
    ], dependencies = [
        DataComponent::class
    ]
)
interface ApplicationComponent {

    fun inject(application: WeatherAppApplication)

    @Component.Builder
    abstract class Builder {
        @BindsInstance
        abstract fun application(application: Application): Builder

        abstract fun dataComponent(dataComponent: DataComponent): Builder

        abstract fun build(): ApplicationComponent
    }
}
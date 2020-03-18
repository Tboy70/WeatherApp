package com.tboy.data.di

import android.content.Context
import com.tboy.data.di.module.DataModule
import com.tboy.data.di.module.ManagerModule
import com.tboy.data.di.module.PersistenceModule
import com.tboy.domain.executor.ThreadExecutor
import com.tboy.domain.repository.WeatherRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class,
        ManagerModule::class,
        PersistenceModule::class
    ]
)

interface DataComponent {

    //We expose our Repositories to dependent scopes
    fun weatherRepository(): WeatherRepository

    fun threadExecutor(): ThreadExecutor

    @Component.Builder
    abstract class Builder {
        @BindsInstance
        abstract fun context(context: Context): Builder

        abstract fun build(): DataComponent
    }

}
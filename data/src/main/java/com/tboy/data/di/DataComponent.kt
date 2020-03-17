package com.tboy.data.di

import android.content.Context
import com.tboy.data.di.module.DataModule
import com.tboy.data.di.module.ManagerModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class,
        ManagerModule::class
    ]
)

interface DataComponent {

    @Component.Builder
    abstract class Builder {
        @BindsInstance
        abstract fun context(context: Context): Builder

        abstract fun build(): DataComponent
    }

}
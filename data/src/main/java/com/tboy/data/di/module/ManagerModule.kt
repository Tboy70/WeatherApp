package com.tboy.data.di.module

import com.tboy.data.manager.api.ApiManager
import com.tboy.data.manager.api.ApiManagerImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ManagerModule {

    @Binds
    @Singleton
    abstract fun apiManager(apiManagerImpl: ApiManagerImpl): ApiManager

}
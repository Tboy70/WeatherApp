package com.tboy.data.di.module

import com.tboy.data.manager.api.ApiManager
import com.tboy.data.manager.api.ApiManagerImpl
import com.tboy.data.manager.db.DBManager
import com.tboy.data.manager.db.DBManagerImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ManagerModule {

    @Binds
    @Singleton
    abstract fun apiManager(apiManagerImpl: ApiManagerImpl): ApiManager

    @Binds
    @Singleton
    abstract fun dbManager(dbManagerImpl: DBManagerImpl): DBManager

}
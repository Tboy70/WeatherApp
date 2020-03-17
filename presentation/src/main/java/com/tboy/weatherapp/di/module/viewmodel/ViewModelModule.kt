package com.tboy.weatherapp.di.module.viewmodel

import androidx.lifecycle.ViewModel
import com.tboy.weatherapp.di.annotation.ViewModelKey
import com.tboy.weatherapp.viewmodel.MainWeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainWeatherViewModel::class)
    abstract fun bindMainWeatherViewModel(mainWeatherViewModel: MainWeatherViewModel): ViewModel

}
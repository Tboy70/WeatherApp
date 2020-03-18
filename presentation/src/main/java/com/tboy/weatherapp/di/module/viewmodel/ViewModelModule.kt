package com.tboy.weatherapp.di.module.viewmodel

import androidx.lifecycle.ViewModel
import com.tboy.weatherapp.di.annotation.ViewModelKey
import com.tboy.weatherapp.viewmodel.CurrentWeatherViewModel
import com.tboy.weatherapp.viewmodel.ForecastWeatherViewModel
import com.tboy.weatherapp.viewmodel.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CurrentWeatherViewModel::class)
    abstract fun bindCurrentWeatherViewModel(currentWeatherViewModel: CurrentWeatherViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ForecastWeatherViewModel::class)
    abstract fun bindForecastWeatherViewModel(forecastWeatherViewModel: ForecastWeatherViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

}
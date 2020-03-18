package com.tboy.weatherapp.viewmodel

import com.tboy.weatherapp.view.state.ForecastWeatherViewState
import com.tboy.weatherapp.viewmodel.base.StateViewModel
import javax.inject.Inject

class ForecastWeatherViewModel @Inject constructor() : StateViewModel<ForecastWeatherViewState>() {

    override val currentViewState = ForecastWeatherViewState()
}
package com.tboy.weatherapp.viewmodel

import com.tboy.weatherapp.view.state.CurrentWeatherViewState
import com.tboy.weatherapp.viewmodel.base.StateViewModel
import javax.inject.Inject

class CurrentWeatherViewModel @Inject constructor() : StateViewModel<CurrentWeatherViewState>() {

    override val currentViewState = CurrentWeatherViewState()
}

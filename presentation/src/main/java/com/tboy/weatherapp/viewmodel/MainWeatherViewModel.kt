package com.tboy.weatherapp.viewmodel

import android.util.Log
import com.tboy.domain.interactor.RetrieveWeatherInformation
import com.tboy.weatherapp.view.state.MainWeatherViewState
import com.tboy.weatherapp.viewmodel.base.StateViewModel
import javax.inject.Inject

class MainWeatherViewModel @Inject constructor(
    private val retrieveWeatherInformation : RetrieveWeatherInformation
) : StateViewModel<MainWeatherViewState>() {

    override val currentViewState = MainWeatherViewState()

    fun retrieveWeatherInformation(coordinates: List<Double>) {
        viewState.update {
            loading = true
        }

        compositeDisposable?.add(
            retrieveWeatherInformation.subscribe(
                params = RetrieveWeatherInformation.Params.toRetrieve(coordinates),
                onSuccess = {
                    Log.e("TEST", "OKTM")
                }, onError = {
                    errorLiveEvent.postValue(it)
                }
            )
        )

    }

}
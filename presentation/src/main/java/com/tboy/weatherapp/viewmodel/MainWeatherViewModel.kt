package com.tboy.weatherapp.viewmodel

import com.tboy.domain.interactor.RetrieveWeatherInformation
import com.tboy.domain.model.WeatherResultEnvelope
import com.tboy.weatherapp.view.state.MainWeatherViewState
import com.tboy.weatherapp.viewmodel.base.StateViewModel
import com.tboy.weatherapp.viewmodel.livedata.SingleLiveEvent
import javax.inject.Inject

class MainWeatherViewModel @Inject constructor(
    private val retrieveWeatherInformation: RetrieveWeatherInformation
) : StateViewModel<MainWeatherViewState>() {

    override val currentViewState = MainWeatherViewState()

    val retrievedWeatherInformationLiveEvent = SingleLiveEvent<WeatherResultEnvelope>()

    fun retrieveWeatherInformation(coordinates: List<Double>) {
        viewState.update {
            loading = true
        }

        compositeDisposable?.add(
            retrieveWeatherInformation.subscribe(
                params = RetrieveWeatherInformation.Params.toRetrieve(coordinates),
                onSuccess = {
                    retrievedWeatherInformationLiveEvent.postValue(it)
                    viewState.update {
                        loading = false
                    }
                }, onError = {
                    errorLiveEvent.postValue(it)
                    viewState.update {
                        loading = false
                    }
                }
            )
        )

    }
}

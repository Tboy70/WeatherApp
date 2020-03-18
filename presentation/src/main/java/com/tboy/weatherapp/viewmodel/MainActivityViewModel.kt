package com.tboy.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.tboy.domain.interactor.RetrieveWeatherInformation
import com.tboy.domain.model.WeatherResultEnvelope
import com.tboy.weatherapp.view.state.MainActivityViewState
import com.tboy.weatherapp.viewmodel.base.StateViewModel
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val retrieveWeatherInformation: RetrieveWeatherInformation
) : StateViewModel<MainActivityViewState>() {

    override val currentViewState = MainActivityViewState()

    val retrievedWeatherInformationLiveData = MutableLiveData<WeatherResultEnvelope>()

    fun retrieveWeatherInformation(coordinates: List<Double>) {
        viewState.update {
            loading = true
        }

        compositeDisposable?.add(
            retrieveWeatherInformation.subscribe(
                params = RetrieveWeatherInformation.Params.toRetrieve(coordinates),
                onSuccess = {
                    retrievedWeatherInformationLiveData.postValue(it)
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
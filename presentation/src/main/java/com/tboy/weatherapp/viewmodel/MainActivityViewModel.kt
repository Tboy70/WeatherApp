package com.tboy.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.tboy.domain.interactor.RetrieveWeatherInformation
import com.tboy.domain.model.WeatherResult
import com.tboy.weatherapp.view.state.MainActivityViewState
import com.tboy.weatherapp.viewmodel.base.StateViewModel
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val retrieveWeatherInformation: RetrieveWeatherInformation
) : StateViewModel<MainActivityViewState>() {

    override val currentViewState = MainActivityViewState()

    private var lastSearchedAndRetrievedCoordinates = listOf<Double>()

    val retrievedWeatherInformationLiveData = MutableLiveData<WeatherResult>()

    fun getLastSearchedAndRetrievedCoordinates() = lastSearchedAndRetrievedCoordinates

    fun retrieveWeatherInformation(coordinates: List<Double>, refreshData: Boolean = false) {
        viewState.update {
            loading = true
        }

        compositeDisposable?.add(
            retrieveWeatherInformation.subscribe(
                params = RetrieveWeatherInformation.Params.toRetrieve(coordinates, refreshData),
                onSuccess = {
                    lastSearchedAndRetrievedCoordinates = coordinates
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
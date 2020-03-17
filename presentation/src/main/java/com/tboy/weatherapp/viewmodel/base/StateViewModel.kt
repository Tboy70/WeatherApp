package com.tboy.weatherapp.viewmodel.base

import androidx.lifecycle.MutableLiveData
import com.tboy.weatherapp.viewmodel.livedata.SingleLiveEvent

abstract class StateViewModel<T> : BaseViewModel() {
    abstract val currentViewState: T

    val viewState = MutableLiveData<T>()
    val errorLiveEvent = SingleLiveEvent<Throwable>()

    protected inline fun <reified T> MutableLiveData<T>.update(block: T.() -> Unit) {
        this.postValue((currentViewState as T).apply(block))
    }
}

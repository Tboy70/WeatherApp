package com.tboy.weatherapp.component.listener

import androidx.annotation.StringRes

interface ErrorRendererComponent {

    fun displayError(throwable: Throwable)
    fun displayErrorString(error: String)
    fun dismissSnackbar()

}
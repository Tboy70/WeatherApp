package com.tboy.weatherapp.component.listener

interface ErrorRendererComponent {

    fun displayError(throwable: Throwable)
    fun displayErrorString(error: String)
    fun dismissSnackbar()

}
package com.tboy.weatherapp.component.listener

interface DialogComponent {

    fun dismissDialog()

    fun displayCustomViewLocationSelection(positiveText: Int, onPositive: (List<Double>) -> Unit)
}
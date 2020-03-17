package com.tboy.weatherapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import com.tboy.weatherapp.R
import com.tboy.weatherapp.component.listener.DialogComponent
import com.tboy.weatherapp.viewmodel.MainWeatherViewModel
import kotlinx.android.synthetic.main.fragment_main_weather.*
import javax.inject.Inject

class MainWeatherFragment : BaseFragment<MainWeatherViewModel>() {

    @Inject
    lateinit var dialogComponent: DialogComponent

    override val viewModelClass = MainWeatherViewModel::class
    override fun getLayoutId(): Int = R.layout.fragment_main_weather

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        main_weather_fab.setOnClickListener {
            dialogComponent.displayCustomViewLocationSelection(
                android.R.string.ok,
                onPositive = {coordinates ->
                    viewModel.retrieveWeatherInformation(coordinates)
                }
            )
        }
    }

}
package com.tboy.weatherapp.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import com.tboy.weatherapp.R
import com.tboy.weatherapp.component.listener.DialogComponent
import com.tboy.weatherapp.component.listener.ErrorRendererComponent
import com.tboy.weatherapp.extension.gone
import com.tboy.weatherapp.extension.observeSafe
import com.tboy.weatherapp.extension.show
import com.tboy.weatherapp.viewmodel.MainWeatherViewModel
import kotlinx.android.synthetic.main.fragment_main_weather.*
import javax.inject.Inject

class MainWeatherFragment : BaseFragment<MainWeatherViewModel>() {

    @Inject
    lateinit var dialogComponent: DialogComponent

    @Inject
    lateinit var errorRendererComponent: ErrorRendererComponent

    override val viewModelClass = MainWeatherViewModel::class
    override fun getLayoutId(): Int = R.layout.fragment_main_weather

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initiateViewModelObservers()
    }

    private fun initViews() {
        main_weather_fab.setOnClickListener {
            dialogComponent.displayCustomViewLocationSelection(
                android.R.string.ok,
                onPositive = { coordinates ->
                    viewModel.retrieveWeatherInformation(coordinates)
                }
            )
        }

        powered_by.setOnClickListener {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://darksky.net/dev")).apply {
                startActivity(this)
            }
        }
    }

    private fun initiateViewModelObservers() {
        viewModel.retrievedWeatherInformationLiveEvent.observeSafe(this) {
            Log.e("TEST", "TEST")
        }

        viewModel.viewState.observeSafe(this) {
            if (it.loading) {
                main_weather_progress_bar.show()
                main_weather_intro_text.gone()
            } else {
                main_weather_progress_bar.gone()
            }
        }

        viewModel.errorLiveEvent.observeSafe(this) {
            errorRendererComponent.displayError(it)
            main_weather_intro_text.show()
        }
    }
}
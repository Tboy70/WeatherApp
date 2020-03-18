package com.tboy.weatherapp.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tboy.weatherapp.R
import com.tboy.weatherapp.extension.observeSafe
import com.tboy.weatherapp.ui.adapter.DailyWeatherListAdapter
import com.tboy.weatherapp.utils.DateUtils
import com.tboy.weatherapp.utils.IconGeneratorUtils
import com.tboy.weatherapp.viewmodel.ForecastWeatherViewModel
import com.tboy.weatherapp.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_forecast_weather.*
import javax.inject.Inject

class ForecastWeatherFragment : BaseFragment<ForecastWeatherViewModel>() {

    override val viewModelClass = ForecastWeatherViewModel::class
    override fun getLayoutId(): Int = R.layout.fragment_forecast_weather

    @Inject
    lateinit var dailyWeatherListAdapter: DailyWeatherListAdapter

    private lateinit var mainWeatherViewModel: MainActivityViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let { activity ->
            mainWeatherViewModel = ViewModelProviders.of(activity, viewModelFactory)
                .get(MainActivityViewModel::class.java)
        }

        initViews()
        initiateViewModelObservers()
    }

    private fun initViews() {

        forecast_weather_list_recycler_view.adapter = dailyWeatherListAdapter
        forecast_weather_list_recycler_view.addItemDecoration(
            DividerItemDecoration(
                activity,
                LinearLayoutManager.VERTICAL
            )
        )
        forecast_weather_list_swipe_refresh_layout.setOnRefreshListener {
            // TODO
        }
        forecast_weather_list_swipe_refresh_layout.setColorSchemeResources(R.color.colorPrimary)
    }

    private fun initiateViewModelObservers() {
        mainWeatherViewModel.retrievedWeatherInformationLiveData.observeSafe(this) {

            resetIcon()

            forecast_weather_timezone.text = it.timezone
            forecast_weather_coordinates.text = getString(R.string.coordinates_text).format(it.latitude, it.longitude)
            forecast_weather_summary.text = it.forecastWeather?.generalSummary

            activity?.let {context ->
                forecast_weather_icon_layout.addView(
                    IconGeneratorUtils.generateWeatherIcon(context, it.forecastWeather?.generalIcon)
                )
            }

            it.forecastWeather?.let {
                dailyWeatherListAdapter.updateItemList(it.data)
            }
        }
    }

    private fun resetIcon() {
        forecast_weather_icon_layout.removeAllViews()
    }

    companion object {
        fun newInstance() = ForecastWeatherFragment()
    }
}
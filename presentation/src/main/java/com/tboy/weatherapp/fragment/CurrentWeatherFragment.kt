package com.tboy.weatherapp.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.tboy.weatherapp.R
import com.tboy.weatherapp.extension.observeSafe
import com.tboy.weatherapp.utils.DateUtils
import com.tboy.weatherapp.utils.IconGeneratorUtils
import com.tboy.weatherapp.viewmodel.CurrentWeatherViewModel
import com.tboy.weatherapp.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_current_weather.*


class CurrentWeatherFragment : BaseFragment<CurrentWeatherViewModel>() {

    override val viewModelClass = CurrentWeatherViewModel::class
    override fun getLayoutId(): Int = R.layout.fragment_current_weather

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

    }

    private fun initiateViewModelObservers() {
        mainWeatherViewModel.retrievedWeatherInformationLiveData.observeSafe(this) {

            resetIcon()

            current_weather_timezone.text = it.timezone
            current_weather_coordinates.text =
                getString(R.string.coordinates_text).format(it.latitude, it.longitude)

            it.currentWeather?.let { currentWeather ->
                activity?.let { activity ->
                    IconGeneratorUtils.generateWeatherIcon(
                        activity,
                        currentWeather.icon
                    )?.let { view ->
                        current_weather_icon_layout.addView(view)
                    }
                }

                current_weather_time.text = currentWeather.time?.let { DateUtils.getDate(it) }
                    current_weather_summary.text = currentWeather.summary
                current_weather_precipIntensity.text =
                    getString(R.string.current_weather_precipIntensity).format(currentWeather.precipIntensity)
                current_weather_precipProbability.text =
                    getString(R.string.current_weather_precipProbability).format(currentWeather.precipProbability)
                current_weather_temperature.text =
                    getString(R.string.current_weather_temperature).format(currentWeather.temperature)
                current_weather_apparentTemperature.text =
                    getString(R.string.current_weather_apparentTemperature).format(currentWeather.apparentTemperature)
                current_weather_humidity.text =
                    getString(R.string.current_weather_humidity).format(currentWeather.humidity)
                current_weather_pressure.text =
                    getString(R.string.current_weather_pressure).format(currentWeather.pressure)
                current_weather_windSpeed.text =
                    getString(R.string.current_weather_windSpeed).format(currentWeather.windSpeed)
                current_weather_cloudCover.text =
                    getString(R.string.current_weather_cloudCover).format(currentWeather.cloudCover)
            }
        }
    }

    private fun resetIcon() {
        current_weather_icon_layout.removeAllViews()
    }

    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }
}
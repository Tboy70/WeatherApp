package com.tboy.weatherapp.ui.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tboy.domain.model.DailyWeather
import com.tboy.weatherapp.R
import com.tboy.weatherapp.utils.DateUtils
import com.tboy.weatherapp.utils.IconGeneratorUtils
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.forecast_weather_list_item.view.*

class DailyWeatherViewHolder(
    itemView: View,
    private val context: Context
) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    override val containerView: View?
        get() = itemView

    fun bind(dailyWeather: DailyWeather) {

        resetIcon()

        itemView.forecast_weather_summary.text = dailyWeather.summary
        itemView.forecast_weather_time.text = dailyWeather.time?.let { DateUtils.getDate(it) }
        itemView.current_weather_icon_layout.addView(
            IconGeneratorUtils.generateWeatherIcon(
                context,
                dailyWeather.icon
            )
        )

        itemView.forecast_weather_temperature_min_max.text =
            context.getString(R.string.forecast_weather_temperature_min_max).format(
                dailyWeather.temperatureMin, dailyWeather.temperatureMax
            )
        itemView.forecast_weather_apparent_temperature_min_max.text =
            context.getString(R.string.forecast_weather_apparent_temperature_min_max).format(
                dailyWeather.apparentTemperatureMin, dailyWeather.apparentTemperatureMax
            )
        itemView.forecast_weather_precip_intensity.text =
            context.getString(R.string.forecast_weather_precip_intensity).format(
                dailyWeather.precipIntensity
            )
        itemView.forecast_weather_precip_probability.text =
            context.getString(R.string.forecast_weather_precip_probability).format(
                dailyWeather.precipProbability
            )
        itemView.forecast_weather_precipType.text =
            context.getString(R.string.forecast_weather_precipType).format(
                dailyWeather.precipType
            )
        itemView.forecast_weather_humidity.text =
            context.getString(R.string.forecast_weather_humidity).format(
                dailyWeather.humidity
            )
        itemView.forecast_weather_pressure.text =
            context.getString(R.string.forecast_weather_pressure).format(
                dailyWeather.pressure
            )
        itemView.forecast_weather_wind_speed.text =
            context.getString(R.string.forecast_weather_wind_speed).format(
                dailyWeather.windSpeed
            )
        itemView.forecast_weather_cloud_cover.text =
            context.getString(R.string.forecast_weather_cloud_cover).format(
                dailyWeather.cloudCover
            )
    }

    private fun resetIcon() {
        itemView.current_weather_icon_layout.removeAllViews()
    }
}
package com.tboy.weatherapp.utils

import android.content.Context
import android.graphics.Color
import android.view.View
import com.thbs.skycons.library.*

const val CLEAR_DAY = "clear-day"
const val CLEAR_NIGHT = "clear-night"
const val RAIN = "rain"
const val SNOW = "snow"
const val SLEET = "sleet"
const val WIND = "wind"
const val FOG = "fog"
const val CLOUDY = "cloudy"
const val PARTIAL_CLOUDY_DAY = "partly-cloudy-day"
const val PARTIAL_CLOUDY_NIGHT = "partly-cloudy-night"

object IconGeneratorUtils {
    fun generateWeatherIcon(context: Context, icon: String?): View? {
        return icon?.let {
            when (it) {
                CLEAR_DAY -> SunView(
                    context,
                    false,
                    true,
                    Color.parseColor("#000000"),
                    android.R.color.transparent
                )
                CLEAR_NIGHT -> MoonView(
                    context,
                    false,
                    true,
                    Color.parseColor("#000000"),
                    android.R.color.transparent
                )
                RAIN -> CloudHvRainView(
                    context,
                    false,
                    true,
                    Color.parseColor("#000000"),
                    android.R.color.transparent
                )
                SNOW -> CloudSnowView(
                    context,
                    false,
                    true,
                    Color.parseColor("#000000"),
                    android.R.color.transparent
                )
                SLEET -> CloudThunderView(
                    context,
                    false,
                    true,
                    Color.parseColor("#000000"),
                    android.R.color.transparent
                )
                WIND -> WindView(
                    context,
                    false,
                    true,
                    Color.parseColor("#000000"),
                    android.R.color.transparent
                )
                FOG -> CloudFogView(
                    context,
                    false,
                    true,
                    Color.parseColor("#000000"),
                    android.R.color.transparent
                )
                CLOUDY -> CloudView(
                    context,
                    false,
                    true,
                    Color.parseColor("#000000"),
                    android.R.color.transparent
                )
                PARTIAL_CLOUDY_DAY -> CloudSunView(
                    context,
                    false,
                    true,
                    Color.parseColor("#000000"),
                    android.R.color.transparent
                )
                PARTIAL_CLOUDY_NIGHT -> CloudMoonView(
                    context,
                    false,
                    true,
                    Color.parseColor("#000000"),
                    android.R.color.transparent
                )
                else -> null
            }
        }
    }
}
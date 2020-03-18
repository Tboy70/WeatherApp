package com.tboy.weatherapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tboy.domain.model.DailyWeather
import com.tboy.weatherapp.R
import com.tboy.weatherapp.ui.viewholder.DailyWeatherViewHolder
import javax.inject.Inject

class DailyWeatherListAdapter @Inject constructor(
    private val context: Context
) : RecyclerView.Adapter<DailyWeatherViewHolder>() {

    private var dataWeatherList = mutableListOf<DailyWeather>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DailyWeatherViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.forecast_weather_list_item,
                parent,
                false
            ), context
        )


    override fun onBindViewHolder(holder: DailyWeatherViewHolder, position: Int) {
        holder.bind(dataWeatherList[position])
    }

    override fun getItemCount(): Int {
        return dataWeatherList.size
    }

    fun updateItemList(dataWeatherList: List<DailyWeather>?) {
        dataWeatherList?.let {
            this.dataWeatherList.clear()
            this.dataWeatherList.addAll(it)
            notifyDataSetChanged()
        }
    }
}
package com.tboy.weatherapp.ui.adapter

import android.annotation.SuppressLint
import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.tboy.weatherapp.fragment.CurrentWeatherFragment
import com.tboy.weatherapp.fragment.ForecastWeatherFragment
import javax.inject.Inject

private const val TAB_CURRENT_WEATHER = "Current"
private const val TAB_FORECAST_WEATHER = "Forecast"

@SuppressLint("WrongConstant")
class MainPagerAdapter @Inject constructor(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var numberOfPage = 2
    private var tabTitles = arrayOf(TAB_CURRENT_WEATHER, TAB_FORECAST_WEATHER)

    private val registeredFragments = SparseArray<Fragment>()

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CurrentWeatherFragment.newInstance()
            1 -> ForecastWeatherFragment.newInstance()
            else -> CurrentWeatherFragment.newInstance()
        }
    }

    override fun getCount(): Int = numberOfPage

    override fun getPageTitle(position: Int): CharSequence = tabTitles[position]

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position) as Fragment
        registeredFragments.put(position, fragment)
        return fragment
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        registeredFragments.remove(position)
        super.destroyItem(container, position, `object`)
    }
}
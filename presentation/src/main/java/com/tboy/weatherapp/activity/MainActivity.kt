package com.tboy.weatherapp.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.tboy.weatherapp.R
import com.tboy.weatherapp.component.listener.DialogComponent
import com.tboy.weatherapp.component.listener.ErrorRendererComponent
import com.tboy.weatherapp.extension.gone
import com.tboy.weatherapp.extension.observeSafe
import com.tboy.weatherapp.extension.show
import com.tboy.weatherapp.ui.adapter.MainPagerAdapter
import com.tboy.weatherapp.viewmodel.MainActivityViewModel
import com.tboy.weatherapp.viewmodel.factory.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var dialogComponent: DialogComponent

    @Inject
    lateinit var errorRendererComponent: ErrorRendererComponent

    @Inject
    lateinit var mainPagerAdapter: MainPagerAdapter

    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)

        initViews()
        initViewPager()
        initiateViewModelObservers()
    }

    private fun initViews() {
        activity_main_fab.setOnClickListener {
            dialogComponent.displayCustomViewLocationSelection(
                android.R.string.ok,
                onPositive = { coordinates ->
                    mainActivityViewModel.retrieveWeatherInformation(coordinates)
                }
            )
        }

        activity_main_powered_by.setOnClickListener {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://darksky.net/dev")).apply {
                startActivity(this)
            }
        }
    }

    private fun initViewPager() {
        activity_main_viewpager.offscreenPageLimit = 2
        activity_main_viewpager.adapter = MainPagerAdapter(supportFragmentManager)
    }

    private fun initiateViewModelObservers() {
        mainActivityViewModel.retrievedWeatherInformationLiveData.observeSafe(this) {
            Log.e("TEST", "TEST")
            activity_main_viewpager.show()
            activity_main_intro_text.gone()
        }

        mainActivityViewModel.viewState.observeSafe(this) {
            if (it.loading) {
                activity_main_progress_bar.show()
                activity_main_intro_text.gone()
            } else {
                activity_main_progress_bar.gone()
            }
        }

        mainActivityViewModel.errorLiveEvent.observeSafe(this) {
            errorRendererComponent.displayError(it)
            activity_main_intro_text.show()
            activity_main_viewpager.gone()
        }
    }
}

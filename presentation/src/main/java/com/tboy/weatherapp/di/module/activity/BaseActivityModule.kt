package com.tboy.weatherapp.di.module.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.tboy.weatherapp.activity.BaseActivity
import com.tboy.weatherapp.component.DialogComponentImpl
import com.tboy.weatherapp.component.ErrorRendererComponentImpl
import com.tboy.weatherapp.component.listener.DialogComponent
import com.tboy.weatherapp.component.listener.ErrorRendererComponent
import com.tboy.weatherapp.di.annotation.PerActivity
import dagger.Module
import dagger.Provides

@Module
class BaseActivityModule {

    @Provides
    @PerActivity
    fun provideSupportFragmentManager(activity: BaseActivity): FragmentManager =
        activity.supportFragmentManager

    @Provides
    @PerActivity
    fun appCompatActivity(baseActivity: BaseActivity) = baseActivity as AppCompatActivity

    @Provides
    @PerActivity
    fun dialogComponent(dialogComponent: DialogComponentImpl): DialogComponent =
        dialogComponent

    @Provides
    @PerActivity
    fun errorRendererComponent(errorRendererComponent: ErrorRendererComponentImpl): ErrorRendererComponent =
        errorRendererComponent

}
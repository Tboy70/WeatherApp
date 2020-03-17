package com.tboy.weatherapp.component

import android.graphics.Color
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.tboy.weatherapp.activity.BaseActivity
import com.tboy.weatherapp.component.listener.ErrorRendererComponent
import com.tboy.weatherapp.di.annotation.PerActivity
import com.tboy.weatherapp.utils.ErrorUtils
import javax.inject.Inject

@PerActivity
class ErrorRendererComponentImpl @Inject constructor(
    private val baseActivity: BaseActivity
) : ErrorRendererComponent {

    private var snackbar: Snackbar? = null

    override fun displayError(throwable: Throwable) {
        snackbar = Snackbar.make(
            baseActivity.findViewById(android.R.id.content),
            ErrorUtils.translateException(baseActivity, throwable),
            Snackbar.LENGTH_LONG
        ).apply {
            setActionTextColor(Color.WHITE)
            view.setBackgroundColor(
                ContextCompat.getColor(
                    baseActivity,
                    android.R.color.holo_red_light
                )
            )

            val textView =
                view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            textView?.setTextColor(ContextCompat.getColor(baseActivity, android.R.color.white))
            textView?.maxLines = 3
            show()
        }
    }

    override fun displayErrorString(error: String) {
        snackbar = Snackbar.make(
            baseActivity.findViewById(android.R.id.content),
            error,
            Snackbar.LENGTH_LONG
        ).apply {
            setActionTextColor(Color.WHITE)
            view.setBackgroundColor(
                ContextCompat.getColor(
                    baseActivity,
                    android.R.color.holo_red_light
                )
            )

            val textView =
                view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            textView?.setTextColor(ContextCompat.getColor(baseActivity, android.R.color.white))
            textView?.maxLines = 3
            show()
        }
    }

    override fun dismissSnackbar() {
        snackbar?.let { if (it.isShown) it.dismiss() }
    }
}
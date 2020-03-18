package com.tboy.weatherapp.component

import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.tboy.domain.values.LocationCoordinates
import com.tboy.weatherapp.R
import com.tboy.weatherapp.activity.BaseActivity
import com.tboy.weatherapp.component.listener.DialogComponent
import com.tboy.weatherapp.di.annotation.PerActivity
import javax.inject.Inject

@PerActivity
class DialogComponentImpl @Inject constructor(
    private val baseActivity: BaseActivity
) : DialogComponent {

    private var materialDialog: MaterialDialog? = null

    override fun dismissDialog() {
        materialDialog?.let {
            if (it.isShowing) {
                it.dismiss()
            }
        }
    }

    override fun displayCustomViewLocationSelection(
        positiveText: Int,
        onPositive: (List<Double>) -> Unit
    ) {
        dismissDialog()
        materialDialog = MaterialDialog(baseActivity).show {}.apply {
            customView(R.layout.view_location_selection)
            cancelOnTouchOutside(true)

            ArrayAdapter.createFromResource(
                baseActivity,
                R.array.list_cities,
                android.R.layout.simple_spinner_item
            ).also {
                it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                getCustomView().findViewById<Spinner>(R.id.view_location_selection_spinner).apply {
                    isSelected = true
                    adapter = it
                }
            }

            positiveButton(positiveText) {
                if (
                    getCustomView().findViewById<TextView>(R.id.view_location_selection_latitude).text.isNotEmpty() &&
                    getCustomView().findViewById<TextView>(R.id.view_location_selection_longitude).text.isNotEmpty()
                ) {
                    onPositive(
                        listOf(
                            getCustomView().findViewById<TextView>(R.id.view_location_selection_latitude).text.toString().toDouble(),
                            getCustomView().findViewById<TextView>(R.id.view_location_selection_longitude).text.toString().toDouble()
                        )
                    )
                } else {
                    onPositive(
                        LocationCoordinates.allList.find {
                            it.first == getCustomView().findViewById<Spinner>(R.id.view_location_selection_spinner).selectedItem
                        }?.second ?: emptyList()
                    )
                }
            }
        }
    }
}
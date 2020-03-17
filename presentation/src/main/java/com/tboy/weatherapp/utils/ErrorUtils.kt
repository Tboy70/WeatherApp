package com.tboy.weatherapp.utils

import android.content.Context
import com.tboy.weatherapp.R
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

object ErrorUtils {

    fun translateException(context: Context, throwable: Throwable): String {
        return when (throwable) {
            is HttpException -> {
                return throwable.message()
            }
            is ConnectException -> return context.getString(R.string.error_connection_problem)
            is UnknownHostException -> return context.getString(R.string.error_server_connection_problem)
            is Exception -> throwable.message.toString()
            else -> return context.getString(R.string.snackbar_error_unknown_error)
        }
    }

}
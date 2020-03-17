package com.tboy.data.manager.api

import com.tboy.data.entity.remote.WeatherResultEnvelopeRemoteEntity
import io.reactivex.Single
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIServiceInterface {

    @GET("{latitude}, {longitude}")
    fun retrieveWeatherInformation(
        @Path("latitude") latitude: Double,
        @Path("longitude") longitude: Double
    ): Single<WeatherResultEnvelopeRemoteEntity>
}
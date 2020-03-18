package com.tboy.data.manager.api

import com.tboy.data.entity.remote.WeatherResultRemoteEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface APIServiceInterface {

    @GET("{latitude}, {longitude}")
    fun retrieveWeatherInformation(
        @Path("latitude") latitude: Double,
        @Path("longitude") longitude: Double
    ): Single<WeatherResultRemoteEntity>
}
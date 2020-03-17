package com.tboy.data.manager.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tboy.data.entity.remote.WeatherResultEnvelopeRemoteEntity
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiManagerImpl @Inject constructor() : ApiManager {

    private var apiService: APIServiceInterface

    companion object {
        const val BASE_URL = "https://api.darksky.net/forecast/b5b8522ebef491c882c795834bfa056d/" // TODO : Key should be encrypted on a final app
    }

    init {
        val gson: Gson = GsonBuilder().setLenient().create()
        val rxAdapter: RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(rxAdapter)
            .client(client)
            .build()
        apiService = retrofit.create(APIServiceInterface::class.java)
    }

    override fun retrieveWeatherInformation(coordinates: List<Double>): Single<WeatherResultEnvelopeRemoteEntity> {
        return apiService.retrieveWeatherInformation(coordinates[0], coordinates[1])
    }
}
package com.tboy.data.business

import com.tboy.data.entity.WeatherResultEnvelopeEntity
import com.tboy.data.manager.api.ApiManager
import com.tboy.data.mapper.remote.WeatherResultEnvelopeRemoteEntityDataMapper
import io.reactivex.Single
import org.json.JSONObject
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class APIBusinessHelper @Inject constructor(
    private val apiManager: ApiManager,
    private val weatherResultEnvelopeRemoteEntityDataMapper: WeatherResultEnvelopeRemoteEntityDataMapper
) {
    fun retrieveWeatherInformation(coordinates: List<Double>): Single<WeatherResultEnvelopeEntity> {
        return apiManager.retrieveWeatherInformation(coordinates)
            .map {
                weatherResultEnvelopeRemoteEntityDataMapper.transformToEntity(it)
            }.onErrorResumeNext {
                // TODO : A better way to do that ?
                if (it is HttpException) {
                    val jsonObject = JSONObject(it.response().errorBody()?.string())
                    Single.error(Exception(jsonObject.getString("error")))
                } else {
                    Single.error(it)
                }
            }
    }

}
package com.tboy.data.business

import com.tboy.data.entity.WeatherResultEntity
import com.tboy.data.manager.api.ApiManager
import com.tboy.data.manager.db.DBManager
import com.tboy.data.mapper.db.WeatherResultDBEntityDataMapper
import com.tboy.data.mapper.remote.WeatherResultRemoteEntityDataMapper
import io.reactivex.Single
import org.json.JSONObject
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class APIBusinessHelper @Inject constructor(
    private val apiManager: ApiManager,
    private val dbManager: DBManager,
    private val weatherResultRemoteEntityDataMapper: WeatherResultRemoteEntityDataMapper,
    private val weatherResultDBEntityDataMapper: WeatherResultDBEntityDataMapper
) {
    fun retrieveWeatherInformation(
        coordinates: List<Double>,
        refreshData: Boolean
    ): Single<WeatherResultEntity> {

        if (refreshData) {
            return retrieveFromAPI(coordinates)
                .onErrorResumeNext {
                    retrieveFromDB(coordinates)
                }.onErrorResumeNext {
                    Single.error(handleError(it))
                }
        } else {
            return retrieveFromDB(coordinates)
                .onErrorResumeNext {
                    retrieveFromAPI(coordinates)
                }.onErrorResumeNext {
                    Single.error(handleError(it))
                }
        }
    }

    private fun retrieveFromAPI(coordinates: List<Double>): Single<WeatherResultEntity> {
        return apiManager.retrieveWeatherInformation(coordinates)
            .map {
                weatherResultRemoteEntityDataMapper.transformToEntity(it)
            }.doOnSuccess {
                dbManager.insertWeatherResult(
                    weatherResultDBEntityDataMapper.transformToDB(
                        it
                    )
                )
            }
    }

    private fun retrieveFromDB(coordinates: List<Double>): Single<WeatherResultEntity> {
        return dbManager.retrieveInformation(coordinates).flatMap {
            Single.just(weatherResultDBEntityDataMapper.transformFromDB(it))
        }
    }

    private fun handleError(it: Throwable): Throwable {
        return if (it is HttpException) {
            val jsonObject = JSONObject(it.response().errorBody()?.string())
            return Exception(jsonObject.getString("error"))
        } else {
            it
        }
    }
}


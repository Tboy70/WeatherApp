package com.tboy.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tboy.data.db.entity.WeatherResultDBEntity
import io.reactivex.Single

@Dao
interface WeatherResultDao {

    @Query("SELECT * FROM WeatherResultDBEntity")
    fun getAll(): Single<List<WeatherResultDBEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherResultDBEntity: WeatherResultDBEntity)

    @Query("DELETE FROM WeatherResultDBEntity")
    fun clearTable()

    @Query("SELECT * FROM WeatherResultDBEntity WHERE latitude=:latitude AND longitude=:longitude  ")
    fun get(latitude: Double, longitude: Double): Single<WeatherResultDBEntity>
}
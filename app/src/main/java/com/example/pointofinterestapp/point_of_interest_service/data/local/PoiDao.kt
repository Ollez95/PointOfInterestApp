package com.example.pointofinterestapp.point_of_interest_service.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pointofinterestapp.point_of_interest_service.model.PoiDaoModel
import com.example.pointofinterestapp.point_of_interest_service.model.PoiModel
import retrofit2.http.GET

/**
 *  Dao Interface for Room Database.
 */
@Dao
interface PoiDao {

    @GET
    @Query("Select * from Poi")
    fun getAllPoi(): List<PoiDaoModel>

    @GET
    @Query("SELECT * FROM Poi WHERE title LIKE '%' || :title || '%'")
    fun searchPoiStadium(title: String): List<PoiDaoModel>

    @GET
    @Query("SELECT * FROM Poi WHERE id = :id")
    fun getPoiById(id: Int): PoiDaoModel

    @Insert
    fun insertAllPoi(allPoi: List<PoiDaoModel>)

}
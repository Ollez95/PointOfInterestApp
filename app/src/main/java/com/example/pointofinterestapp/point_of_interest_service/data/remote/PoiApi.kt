package com.example.pointofinterestapp.point_of_interest_service.data.remote

import com.example.pointofinterestapp.point_of_interest_service.model.PoiModel
import com.example.pointofinterestapp.point_of_interest_service.model.PoiModelList
import retrofit2.http.GET
import retrofit2.http.Headers

/***
 * Retrofit Api to get initial data
 */
interface PoiApi {

    /***
     * Query to Poi endpoint
     */
    @Headers("Content-Type: application/json")
    @GET("pois.json")
    suspend fun getPoiEndpoint(): PoiModelList


    companion object {
        const val BASE_URL = "https://sergiocasero.es/"
    }

}
package com.example.pointofinterestapp.point_of_interest_service.domain.local

import com.example.pointofinterestapp.point_of_interest_service.model.PoiDaoModel
import com.example.pointofinterestapp.point_of_interest_service.model.PoiModel
import com.example.pointofinterestapp.point_of_interest_service.utils.Resource
import kotlinx.coroutines.flow.Flow


/**
 * Interface for our Local repository.
 */
interface PoiLocalRepository {

    suspend fun insertAllPoi(allPoi: List<PoiDaoModel>)

    suspend fun getAllPoi(): Flow<Resource<List<PoiDaoModel>>>

    suspend fun getPoiById(id: Int): Flow<PoiDaoModel>

    suspend fun searchPoiStadium(stadium: String): Flow<List<PoiDaoModel>>

}
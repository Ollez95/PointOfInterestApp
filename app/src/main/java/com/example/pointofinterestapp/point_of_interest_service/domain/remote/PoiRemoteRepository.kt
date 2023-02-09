package com.example.pointofinterestapp.point_of_interest_service.domain.remote

import com.example.pointofinterestapp.point_of_interest_service.model.PoiModel
import com.example.pointofinterestapp.point_of_interest_service.model.PoiModelList
import com.example.pointofinterestapp.point_of_interest_service.utils.Resource
import kotlinx.coroutines.flow.Flow


/**
 * Interface for our Remote repository.
 */
interface PoiRemoteRepository {

    suspend fun getPoiData(): Flow<Resource<PoiModelList>>

}
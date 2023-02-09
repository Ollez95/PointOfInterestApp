package com.example.pointofinterestapp.point_of_interest_service.domain.remote

import com.example.pointofinterestapp.point_of_interest_service.data.remote.PoiApi
import com.example.pointofinterestapp.point_of_interest_service.model.PoiModel
import com.example.pointofinterestapp.point_of_interest_service.model.PoiModelList
import com.example.pointofinterestapp.point_of_interest_service.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Implementation of our Remote Repository.
 */
@Singleton
class PoiRemoteRepositoryImpl @Inject constructor(
    private val api: PoiApi
) : PoiRemoteRepository {

    override suspend fun getPoiData(): Flow<Resource<PoiModelList>> {
        return flow {
            emit(Resource.Loading(true))

            try {
                val response = api.getPoiEndpoint()
                emit(Resource.Success(response))
            }
            catch (e : IOException){
                e.printStackTrace()
                emit(Resource.Error(message = e.message!!))
            }
            catch (e : HttpException){
                e.printStackTrace()
                emit(Resource.Error(message = e.message!!))
            }
            emit(Resource.Loading(false))
        }
    }
}
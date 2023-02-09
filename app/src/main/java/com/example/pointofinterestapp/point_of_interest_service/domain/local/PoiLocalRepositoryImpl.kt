package com.example.pointofinterestapp.point_of_interest_service.domain.local

import android.util.Log
import com.example.pointofinterestapp.point_of_interest_service.data.local.PoiDao
import com.example.pointofinterestapp.point_of_interest_service.model.PoiDaoModel
import com.example.pointofinterestapp.point_of_interest_service.utils.Resource
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Implementation of our Local Repository.
 */
@Singleton
class PoiLocalRepositoryImpl @Inject constructor(
    private val poiDao: PoiDao
) : PoiLocalRepository {

    override suspend fun insertAllPoi(allPoi: List<PoiDaoModel>) {
        poiDao.insertAllPoi(allPoi)
    }

    override suspend fun getAllPoi(): Flow<Resource<List<PoiDaoModel>>> {
        return flow {
            emit(Resource.Loading(true))

            try {
                val response = poiDao.getAllPoi()
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
        /*callbackFlow {
            val response = poiDao.getAllPoi()
            trySend(response)
            awaitClose {
                close(Throwable(message = "closed"))
            }

    }*/

    override suspend fun getPoiById(id: Int): Flow<PoiDaoModel> =
        callbackFlow {
            val response = poiDao.getPoiById(id)
            trySend(response)
            awaitClose {
                close(Throwable(message = "closed"))
        }
    }

    override suspend fun searchPoiStadium(stadium: String): Flow<List<PoiDaoModel>> =
        callbackFlow {
            val response = poiDao.searchPoiStadium(stadium)
            trySend(response)
            awaitClose {
                close(Throwable(message = "closed"))
            }
    }
}
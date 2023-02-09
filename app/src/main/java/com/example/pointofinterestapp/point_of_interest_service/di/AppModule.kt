package com.example.pointofinterestapp.point_of_interest_service.di

import android.content.Context
import androidx.room.Room
import com.example.pointofinterestapp.point_of_interest_service.data.local.PoiDao
import com.example.pointofinterestapp.point_of_interest_service.data.local.PoiDatabase
import com.example.pointofinterestapp.point_of_interest_service.data.remote.PoiApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


/**
 * App Module with all the singletons that only need to be instanciated one time. For example,
 * Room and Retrofit main instances.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePoiAPi(): PoiApi {
        return Retrofit.Builder()
            .baseUrl(PoiApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providesRoomDatabase(@ApplicationContext context: Context) : PoiDatabase {
        return Room.databaseBuilder(
            context,
            PoiDatabase::class.java, "poi-database"
        ).build()
    }

    @Provides
    @Singleton
    fun providesPoiDao(poiDatabase: PoiDatabase): PoiDao {
        return poiDatabase.poiDao()
    }


}
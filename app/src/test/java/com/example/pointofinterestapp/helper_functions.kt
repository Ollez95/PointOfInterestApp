package com.example.pointofinterestapp

import android.content.Context
import androidx.room.Room
import com.example.pointofinterestapp.point_of_interest_service.data.local.PoiDao
import com.example.pointofinterestapp.point_of_interest_service.data.local.PoiDatabase
import com.example.pointofinterestapp.point_of_interest_service.data.remote.PoiApi
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

fun createApi(): PoiApi {
    return Retrofit.Builder()
        .baseUrl(PoiApi.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create()
}
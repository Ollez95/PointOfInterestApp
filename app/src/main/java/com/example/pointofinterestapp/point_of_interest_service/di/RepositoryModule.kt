package com.example.pointofinterestapp.point_of_interest_service.di

import com.example.pointofinterestapp.point_of_interest_service.domain.local.PoiLocalRepository
import com.example.pointofinterestapp.point_of_interest_service.domain.local.PoiLocalRepositoryImpl
import com.example.pointofinterestapp.point_of_interest_service.domain.remote.PoiRemoteRepository
import com.example.pointofinterestapp.point_of_interest_service.domain.remote.PoiRemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Repository Module with all the instances that only to be instantiated one time.
 * One for Local Repository and another for Remote Repository
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsPoiRemoteRepository(
        poiRemoteRepositoryImpl: PoiRemoteRepositoryImpl
    ) : PoiRemoteRepository

    @Binds
    @Singleton
    abstract fun bindsPoiLocalRepository(
        poiLocalRepositoryImpl: PoiLocalRepositoryImpl
    ): PoiLocalRepository


}
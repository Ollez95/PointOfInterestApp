package com.example.pointofinterestapp.point_of_interest_service.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pointofinterestapp.point_of_interest_service.model.PoiDaoModel

/**
 *  Room Database for initalization.
 */
@Database(entities = [PoiDaoModel::class], version = 1)
abstract class PoiDatabase: RoomDatabase() {

    abstract fun poiDao(): PoiDao

}
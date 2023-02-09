package com.example.pointofinterestapp

import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.pointofinterestapp.point_of_interest_service.data.local.PoiDao
import com.example.pointofinterestapp.point_of_interest_service.data.local.PoiDatabase
import com.example.pointofinterestapp.point_of_interest_service.model.PoiDaoModel
import kotlinx.coroutines.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.concurrent.CountDownLatch

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@SmallTest
@RunWith(AndroidJUnit4::class)
class PoiLocalTests {

    private lateinit var database: PoiDatabase
    private lateinit var dao: PoiDao

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            PoiDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.poiDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDatabase() {
        database.close()
    }

    /**
     * Test to check if insert and get are working
     */
    @Test
    @Throws(Exception::class)
    fun insert_dao_and_get_data() = runBlocking {
        val data = listOf(PoiDaoModel(id = 1, "Camp Nou", "", ""))
        dao.insertAllPoi(data)
        val dao = dao.getAllPoi()
        assertEquals(dao, data)
    }

    /**
     * Test to check if insert and get by id are working
     */
    @Test
    @Throws(Exception::class)
    fun insert_dao_and_get_by_id() = runBlocking {
        val data = listOf(PoiDaoModel(id = 1, "Camp Nou", "", ""))
        dao.insertAllPoi(data)
        val dao = dao.getPoiById(1)
        assertEquals(dao, data[0])
    }


    /**
     * Test to check if insert and and count all items are working
     */
    @Test
    @Throws(Exception::class)
    fun count_number_dao() = runBlocking {
        val data = listOf(
            PoiDaoModel(id = 1, "Camp Nou", "", ""),
            PoiDaoModel(id = 2, "Test", "", ""),
            PoiDaoModel(id = 3, "Test2", "", ""))
        dao.insertAllPoi(data)
        val dao = dao.getAllPoi()
        assertEquals(dao.size, 3)
    }

    /**
     * Test to check if insert and search are working
     */
    @Test
    @Throws(Exception::class)
    fun search_poi_test() = runBlocking {
        val data = listOf(
            PoiDaoModel(id = 1, "Camp Nou", "", ""),
            PoiDaoModel(id = 2, "Test", "", ""),
            PoiDaoModel(id = 3, "Test2", "", "")
        )
        dao.insertAllPoi(data)
        val searchPoi = dao.searchPoiStadium("te")
        assertEquals(searchPoi.size, 2)
    }
}
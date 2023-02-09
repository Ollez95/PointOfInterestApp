package com.example.pointofinterestapp

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals

import org.junit.Test


class PoiRemoteTests(){

    @Test
    fun `test for remote api`(){

        val api = createApi()
        runBlocking {
            val request = api.getPoiEndpoint()
            val requestSimplify = request.list
            assertEquals(requestSimplify.size, 14)
        }
    }
}
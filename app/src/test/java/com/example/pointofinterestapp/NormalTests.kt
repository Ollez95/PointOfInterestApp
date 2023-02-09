package com.example.pointofinterestapp

import com.example.pointofinterestapp.point_of_interest_service.presentation.poi_detail.processLatitudeLongitude
import org.junit.Assert
import org.junit.Test

class NormalTests {
    /**
     * Test to check latitude and longitude function
     */
    @Test
    fun `test transform latitude longitude`(){
        val longLat = processLatitudeLongitude("41.3809,2.1206311")

        Assert.assertEquals(longLat, Pair(41.3809, 2.1206311))

    }

}
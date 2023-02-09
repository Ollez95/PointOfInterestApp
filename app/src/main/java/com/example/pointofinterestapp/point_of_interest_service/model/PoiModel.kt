package com.example.pointofinterestapp.point_of_interest_service.model

import androidx.room.Entity

/***
 * Data class for remote repository
 * We use this model in our flows.
 */
data class PoiModel(
    val id: Int? = 0,
    val title: String = "",
    val geocoordinates: String = "",
    val image: String = ""
)

fun PoiModel.toPoiDaoModel() =

    PoiDaoModel(
        id = this.id!!,
        title = this.title,
        geocoordinates = this.geocoordinates,
        image = this.image
    )




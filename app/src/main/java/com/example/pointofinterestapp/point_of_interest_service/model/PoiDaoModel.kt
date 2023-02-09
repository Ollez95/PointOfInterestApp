package com.example.pointofinterestapp.point_of_interest_service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/***
 * Data class for local repository
 */
@Entity(tableName = "Poi")
data class PoiDaoModel(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String = "",
    @ColumnInfo(name = "geocoordinates") val geocoordinates: String = "",
    @ColumnInfo(name = "image") val image: String = ""
)


fun PoiDaoModel.toPoiModel() =
    PoiModel(
        id = this.id,
        title = this.title,
        geocoordinates = this.geocoordinates,
        image = this.image
    )
package com.example.pointofinterestapp.point_of_interest_service.presentation.poi_detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

/**
 * This is the View of Google Maps:
 * To activate this functionality you need to go to AndroidManifest.xml and add
 * a api key in the line:
 * <meta-data android:name="com.google.android.geo.API_KEY" android:value=""/>
 */
@Composable
fun PoiGoogleMaps(
    title: String,
    latLong: String) {

    val (latitude,longitude) = processLatitudeLongitude(latLong)

    val stadium = LatLng(latitude, longitude)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(stadium, 15f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {

        Marker(
            state = MarkerState(position = stadium),
            title = title,
            snippet = "Stadium $title in Spain"
        )
    }
}


fun processLatitudeLongitude(latLong: String) : Pair<Double, Double>{

    val coordinates = latLong.split(",")
    val latitude = coordinates[0].toDouble()
    val longitude = coordinates[1].toDouble()

    return Pair(latitude, longitude)

}


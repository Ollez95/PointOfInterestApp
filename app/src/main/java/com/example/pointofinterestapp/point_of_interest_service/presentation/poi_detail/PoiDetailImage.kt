package com.example.pointofinterestapp.point_of_interest_service.presentation.poi_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size


/**
 * This a Point of Interest Detail Image View
 */
@Composable
fun PoiDetailImage(
    pathImageUrl: String,
    height: Dp,
) {

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(pathImageUrl)
            .crossfade(500)
            .size(Size.ORIGINAL) // Set the target size to load the image at.
            .build())

    val painterState = painter.state

    if (painterState is AsyncImagePainter.State.Loading) {
        Row(
            modifier = Modifier
                .height(height)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            CircularProgressIndicator(
                strokeWidth=6.dp,
                color = MaterialTheme.colors.primary)
        }}
    else{
        ImageItem(
            painter = painter,
            height = height
        )
    }

}

/**
 * This a Point of Interest Image Item
 */
@Composable
fun ImageItem(modifier: Modifier = Modifier,
              painter: AsyncImagePainter,
              height: Dp
) {
    Image(
        painter = painter,
        contentDescription = "Stadium Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .then(modifier)
    )
}

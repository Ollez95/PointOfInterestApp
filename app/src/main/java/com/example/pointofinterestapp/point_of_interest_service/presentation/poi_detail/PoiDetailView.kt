package com.example.pointofinterestapp.point_of_interest_service.presentation.poi_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pointofinterestapp.composables.PoiTopDetailAppBar
import com.example.pointofinterestapp.point_of_interest_service.presentation.PoiScaffold
import com.example.pointofinterestapp.point_of_interest_service.presentation.PoiViewModel
import com.example.pointofinterestapp.ui.theme.Typography


/**
 * This is a view where you can see a detail about a stadium. Basically an image and coordenates in
 * google maps.
 */
@Composable
fun PoiDetailView(
    navigateBack: () -> Unit,
    poiViewModel: PoiViewModel
) {

    val poiDetailData = poiViewModel.poiDataDetailSelected.collectAsState().value

    PoiScaffold(
        topAppBar = {
            PoiTopDetailAppBar(
                navigateBack = navigateBack
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            ) {
                Text(
                    text = poiDetailData.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = Typography.h5.fontSize,
                    fontFamily = Typography.h5.fontFamily
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            PoiDetailImage(poiDetailData.image, height = 160.dp)
            Spacer(modifier = Modifier.height(16.dp))

            PoiGoogleMaps(
                title = poiDetailData.title, latLong = poiDetailData.geocoordinates
            )

        }
    }
}


package com.example.pointofinterestapp.point_of_interest_service.presentation.poi_view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pointofinterestapp.ui.theme.Typography


/**
 * This a Point Of Interest Item where you have the id number and name of the stadium.
 */
@Composable
fun PoiItem(
    idText: String,
    stadiumText: String,
    navigateToDetail: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(4.dp)
            .clickable {
                navigateToDetail()
            }

    ) {
        Spacer(modifier = Modifier.width(8.dp))

        // Without the modifier parameter the search query does not work correctly
        // idk why. Probably some bug

        Text(text = idText,
            fontSize = Typography.h6.fontSize,
            fontFamily = Typography.h6.fontFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {
                navigateToDetail()
            })

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {
            Text(
                text = stadiumText,
                fontSize = Typography.h6.fontSize,
                fontFamily = Typography.h6.fontFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navigateToDetail()
                }
            )
        }

    }
}

@Preview
@Composable
private fun PoiItemPreview() {
    PoiItem(
        idText = "1",
        stadiumText = "Camp Nou",
        navigateToDetail = {})
}
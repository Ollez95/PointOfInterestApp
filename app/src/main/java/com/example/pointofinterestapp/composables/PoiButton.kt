package com.example.pointofinterestapp.composables

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pointofinterestapp.ui.theme.Typography

/**
 * Point of Interest Button
 */
@Composable
fun PoiButton(
    text: String,
    enabled: Boolean = true,
    execution: () -> Unit,

){
    Button(
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        onClick = {
            execution()
        }) {
        Text(
            text = text,
            fontFamily = Typography.button.fontFamily,
            fontSize = Typography.button.fontSize,
            fontWeight = Typography.button.fontWeight
        )
    }
}

@Preview
@Composable
private fun PoiButtonDefault(){
    PoiButton(
        text = "Get Poi Data"
    ) {

    }
}
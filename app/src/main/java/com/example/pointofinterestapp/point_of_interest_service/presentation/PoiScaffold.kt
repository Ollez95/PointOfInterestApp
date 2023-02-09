package com.example.pointofinterestapp.point_of_interest_service.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


/**
* This is a scaffold model for our 2 views.
 */
@Composable
fun PoiScaffold(
    topAppBar: @Composable () -> Unit,
    content: @Composable (paddingValues: PaddingValues) -> Unit
){

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { topAppBar() },
        content = {
            content(it)
        }
    )
}

@Preview
@Composable
fun PoiScaffoldPreview(){
    PoiScaffold(
        {},
        {}
    )
}
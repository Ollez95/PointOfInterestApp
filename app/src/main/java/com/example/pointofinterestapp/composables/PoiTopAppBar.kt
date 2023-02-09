package com.example.pointofinterestapp.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.pointofinterestapp.R

/**
 * App Main View Top Bar
 */
@Composable
fun PoiTopViewAppBar(){
    TopAppBar() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(stringResource(id = R.string.app_name_title))
        }
    }
}

/**
 * App Detail Top Bar
 */
@Composable
fun PoiTopDetailAppBar(
    navigateBack: () -> Unit = {}){
    TopAppBar() {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back to Poi View",
                modifier = Modifier.clickable { navigateBack() })

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(stringResource(id = R.string.app_name_title))
            }

        }
    }
}

@Preview
@Composable
private fun PoiTopAppBarPreview(){
    PoiTopViewAppBar()
}

@Preview
@Composable
private fun PoiTopDetailAppBarPreview(){
    PoiTopDetailAppBar()
}
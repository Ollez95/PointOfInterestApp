package com.example.pointofinterestapp.point_of_interest_service.presentation.poi_view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pointofinterestapp.R
import com.example.pointofinterestapp.composables.PoiButton
import com.example.pointofinterestapp.composables.PoiTextField
import com.example.pointofinterestapp.composables.PoiTopViewAppBar
import com.example.pointofinterestapp.point_of_interest_service.presentation.PoiScaffold
import com.example.pointofinterestapp.point_of_interest_service.presentation.PoiViewModel
import com.example.pointofinterestapp.point_of_interest_service.presentation.poi_detail.PoiDetailView

/**
 * This is the main view in the application:
 *  - It has a button where you can call the remote data. If it has pressed you use
 *  the local data.
 *  - It has a search text button for search for stadiums.
 *  - It has a list with poiItems.
 *  - Loading for get local Data
 */
@Composable
fun PoiView(
    viewModel: PoiViewModel,
    onNavigateToDetail: () -> Unit
) {

    val dataExtracted = rememberSaveable { mutableStateOf(false) }
    val textSearch = rememberSaveable { mutableStateOf("") }
    val poiItems = viewModel.poiData.collectAsState().value
    val loading = viewModel.loading.collectAsState().value

    PoiScaffold(
        topAppBar = { PoiTopViewAppBar() }
    ) {
        if (loading) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressIndicator(
                    strokeWidth = 6.dp,
                    color = MaterialTheme.colors.primary
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .fillMaxWidth()
            ) {

                item {

                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        PoiButton(
                            text = stringResource(id = R.string.get_poi_remote),
                            enabled = poiItems.isEmpty()
                        ) {
                            dataExtracted.value = true
                            viewModel.getPoiRemoteData()
                        }
                    }
                }

                item {
                    PoiTextField(
                        text = textSearch,
                        placeholder = stringResource(id = R.string.search_for_stadium),
                        percentageWidth = 1f,
                        searchStadium = {
                            viewModel.searchPoiLocalData(
                                textSearch.value
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }

                itemsIndexed(poiItems) { _, poiItem ->

                    PoiItem(
                        idText = poiItem.id.toString(),
                        stadiumText = poiItem.title,
                        navigateToDetail = {
                            viewModel.getPoiById(poiItem.id!!)
                            onNavigateToDetail()
                        }
                    )


                }
            }
        }

    }


}

@Preview
@Composable
private fun PoiDetailViewPreview() {
    PoiDetailView(
        {},
        hiltViewModel()
    )
}
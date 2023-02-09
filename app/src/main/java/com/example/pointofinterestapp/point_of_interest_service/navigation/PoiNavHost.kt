package com.example.pointofinterestapp.point_of_interest_service.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pointofinterestapp.point_of_interest_service.presentation.PoiDetailView
import com.example.pointofinterestapp.point_of_interest_service.presentation.PoiView
import com.example.pointofinterestapp.point_of_interest_service.presentation.PoiViewModel

/**
 * This is the nav host navigator. Essentially has 2 views to where you can navigate:
 * - poi_view -> First View
 * - detail_view -> View with detail about stadiums
 */
@Composable
fun PoiNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "poi_view"
){
    NavHost(
        navController= navController,
        startDestination =  startDestination,
        modifier = modifier)
    {
        composable("poi_view"){ backStackEntry ->

            val parentEntry: NavBackStackEntry = remember(backStackEntry) {
                navController.getBackStackEntry("poi_view")
            }
            val poiViewModel = hiltViewModel<PoiViewModel>(parentEntry)

            PoiView(
                viewModel = poiViewModel
            ) {
                navController.navigate("poi_detail")
            }
        }

        composable("poi_detail"){  backStackEntry ->

            val parentEntry: NavBackStackEntry = remember(backStackEntry) {
                navController.getBackStackEntry("poi_view")
            }
            val poiViewModel = hiltViewModel<PoiViewModel>(parentEntry)

            PoiDetailView(
                navigateBack = {navController.popBackStack()},
                poiViewModel = poiViewModel)
        }
    }
}
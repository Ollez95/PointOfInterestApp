package com.example.pointofinterestapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pointofinterestapp.point_of_interest_service.navigation.PoiNavHost
import com.example.pointofinterestapp.point_of_interest_service.presentation.PoiViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {



            PoiNavHost()
        }
    }
}




package com.example.pointofinterestapp.point_of_interest_service.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pointofinterestapp.point_of_interest_service.domain.local.PoiLocalRepository
import com.example.pointofinterestapp.point_of_interest_service.domain.remote.PoiRemoteRepository
import com.example.pointofinterestapp.point_of_interest_service.model.*
import com.example.pointofinterestapp.point_of_interest_service.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * This is the view model of the application. It has 2 flows, one for the total list of data and other
 * for the selected detail poi item.
 */
@HiltViewModel
class PoiViewModel @Inject constructor(
    private val poiRemoteRepository: PoiRemoteRepository,
    private val poiLocalRepository: PoiLocalRepository
) : ViewModel() {

    private val _poiData = MutableStateFlow<List<PoiModel>>(listOf())
    val poiData: StateFlow<List<PoiModel>> = _poiData

    private val _poiDataDetailSelected = MutableStateFlow(PoiModel())
    val poiDataDetailSelected: StateFlow<PoiModel> = _poiDataDetailSelected

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading


    init {
        getPoiLocalData()
    }

    fun insertPoiLocalData(){
        viewModelScope.launch(Dispatchers.IO) {
            val poiDaoData = poiData.value.map { it.toPoiDaoModel() }
            poiLocalRepository.insertAllPoi(poiDaoData)
        }
    }

    private fun getPoiLocalData(){
        println(poiData.value)
        viewModelScope.launch(Dispatchers.IO) {
            poiLocalRepository.getAllPoi().collect {
                    response ->
                println(response)
                when(response){
                    is Resource.Success -> {
                        _poiData.value = response.data!!.map { it.toPoiModel() }
                        _loading.value = false
                    }
                    is Resource.Error -> {
                        Log.d("ErrorLocal", response.message.toString())
                    }
                    is Resource.Loading -> {
                        Log.d("Loading", response.message.toString())
                    }
                }

            }
        }
    }

    fun searchPoiLocalData(stadium: String){
        viewModelScope.launch(Dispatchers.IO) {

            poiLocalRepository.searchPoiStadium(stadium).collect { response ->
                _poiData.value = response.map { it.toPoiModel() }
            }
        }
    }

    fun getPoiById(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            poiLocalRepository.getPoiById(id).collect { response ->
                _poiDataDetailSelected.value = response.toPoiModel()
            }
        }
    }

    fun getPoiRemoteData(){
        viewModelScope.launch(Dispatchers.IO) {
            poiRemoteRepository.getPoiData().collect {
                result ->

                when(result){
                    is Resource.Success -> {

                        val mutableListPoi = mutableListOf<PoiModel>()
                        result.data!!.list.map { mutableListPoi.add(it) }
                        _poiData.value = mutableListPoi.toList()

                        /* After getting the remote data we add the same data to the
                        local repository */
                        insertPoiLocalData()

                    }
                    is Resource.Error -> {
                        Log.d("ErrorRemote", result.message.toString())
                    }
                    is Resource.Loading -> {
                        Log.d("Loading", result.message.toString())
                    }
                }


            }
        }
    }

}
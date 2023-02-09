package com.example.pointofinterestapp.point_of_interest_service.utils

/***
 * Class that returns Flow State in remote calls.
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null){
    class Success<T>(data: T?): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
    class Loading<T>(val isLoading: Boolean = true): Resource<T>(null)
}
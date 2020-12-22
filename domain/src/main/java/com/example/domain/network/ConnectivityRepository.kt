package com.example.domain.network

interface ConnectivityRepository {

    fun isDeviceConnectedToInternet(): Boolean
}
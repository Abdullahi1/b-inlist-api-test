package com.example.apitest.network

import android.net.ConnectivityManager
import com.example.domain.network.ConnectivityRepository
import javax.inject.Inject

class ConnectivityRepositoryImpl @Inject constructor(private val connectivityManager: ConnectivityManager) :
    ConnectivityRepository {

    override fun isDeviceConnectedToInternet(): Boolean =
        connectivityManager.activeNetworkInfo != null
}
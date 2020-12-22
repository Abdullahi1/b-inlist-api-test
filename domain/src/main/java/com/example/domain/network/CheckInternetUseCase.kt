package com.example.domain.network

import com.example.domain.common.UseCase
import javax.inject.Inject

class CheckInternetUseCase @Inject constructor(private val connectivityRepository: ConnectivityRepository) :
    UseCase<Unit, Boolean>() {

    override fun invoke(param: Unit): Boolean =
        connectivityRepository.isDeviceConnectedToInternet()
}
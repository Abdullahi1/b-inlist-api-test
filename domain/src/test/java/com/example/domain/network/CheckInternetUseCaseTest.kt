package com.example.domain.network

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class CheckInternetUseCaseTest {
    private lateinit var connectivityRepository: ConnectivityRepository
    private lateinit var checkInternetUseCase: CheckInternetUseCase

    @Before
    fun init() {
        connectivityRepository = mock()
        checkInternetUseCase = CheckInternetUseCase(connectivityRepository)
    }

    @Test
    fun `ensure that is-device-connectedMethod method is called in the repository is called`() {
        runBlockingTest {
            checkInternetUseCase(Unit)

            verify(connectivityRepository).isDeviceConnectedToInternet()
        }
    }
}
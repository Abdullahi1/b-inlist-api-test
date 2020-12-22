package com.example.data.cardInfo

import com.example.data.api.ApiService
import com.example.data.common.TestData
import com.example.domain.cardInfo.CardInfoRepository
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test


class CardInfoRepositoryImplTest {

    private val apiService: ApiService = mock()
    private val mapper: CardInfoMapper = mock()

    private lateinit var cardInfoRepository: CardInfoRepository

    @Before
    fun init() {
        cardInfoRepository = CardInfoRepositoryImpl(
            apiService = apiService,
            mapper = mapper
        )
    }

    @Test
    fun `return success when card info is retrieved`() {
        runBlocking {
            whenever(apiService.fetchCardInfo(any()))
                .thenReturn(TestData.createSuccessfulCardInfoResponse())

            val result = cardInfoRepository.getCardInfo("")

            assertTrue(result.isSuccess())
        }
    }


}
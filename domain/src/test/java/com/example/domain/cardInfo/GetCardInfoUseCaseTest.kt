package com.example.domain.cardInfo

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetCardInfoUseCaseTest {
    private lateinit var cardInfoRepository: CardInfoRepository
    private lateinit var getCardInfoUseCase: GetCardInfoUseCase

    @Before
    fun init() {
        cardInfoRepository = mock()
        getCardInfoUseCase = GetCardInfoUseCase(cardInfoRepository)
    }

    @Test
    fun `ensure that get-card-info method is called in the repository is called`() {
        runBlockingTest {
            val accountNumber = "123456"
            getCardInfoUseCase(accountNumber)

            verify(cardInfoRepository).getCardInfo(accountNumber = accountNumber)
        }
    }
}
package com.example.data.cardInfo

import com.example.data.api.ApiService
import com.example.data.common.sendRequest
import com.example.domain.cardInfo.CardInfoRepository
import com.example.domain.common.Result
import com.example.domain.model.CardInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CardInfoRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: CardInfoMapper
) : CardInfoRepository {
    override suspend fun getCardInfo(accountNumber: String): Result<CardInfo> =
        withContext(Dispatchers.IO) {
            val result = sendRequest { apiService.fetchCardInfo(cardNumber = accountNumber) }

            if (result.isError()) {
                return@withContext Result.error(message = result.message)
            }

            return@withContext Result.success(mapper.from(result.data!!))
        }
}
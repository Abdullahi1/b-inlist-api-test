package com.example.domain.cardInfo

import com.example.domain.common.Result
import com.example.domain.model.CardInfo

interface CardInfoRepository {
    suspend fun getCardInfo(accountNumber: String): Result<CardInfo>
}
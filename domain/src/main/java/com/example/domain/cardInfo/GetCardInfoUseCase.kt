package com.example.domain.cardInfo

import com.example.domain.common.Result
import com.example.domain.common.SuspendUseCase
import com.example.domain.model.CardInfo
import javax.inject.Inject

class GetCardInfoUseCase @Inject constructor(
    private val cardInfoRepository: CardInfoRepository
) : SuspendUseCase<String, Result<CardInfo>>() {
    override suspend fun invoke(param: String): Result<CardInfo> =
        cardInfoRepository.getCardInfo(param)
}
package com.example.data.cardInfo

import com.example.data.common.Mapper
import com.example.data.model.CardInfoResponse
import com.example.domain.model.CardInfo
import javax.inject.Inject

class CardInfoMapper @Inject constructor() : Mapper<CardInfoResponse, CardInfo> {
    override fun to(domain: CardInfo): CardInfoResponse {
        TODO("Not yet implemented")
    }

    override fun from(entity: CardInfoResponse): CardInfo = entity.run {
        CardInfo(
            cardScheme = scheme ?: "",
            cardType = type ?: "",
            bankName = bank.name ?: "",
            countryName = country.name ?: "",
            isPrepaid = prepaid ?: false,
            cardNumberLength = if (number.length == null) "" else number.length.toString()
        )
    }
}
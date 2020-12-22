package com.example.data.common

import com.example.data.model.CardInfoResponse

object TestData {
    fun createSuccessfulCardInfoResponse(): CardInfoResponse =
        CardInfoResponse(
            bank = CardInfoResponse.Bank(
                name = "Jyske Bank"
            ),
            number = CardInfoResponse.Number(
                length = 16
            ),
            country = CardInfoResponse.Country(
                name = "Denmark"
            ),
            prepaid = true,
            scheme = "visa",
            type = "debit"
        )
}
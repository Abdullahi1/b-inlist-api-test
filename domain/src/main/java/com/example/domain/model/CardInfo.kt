package com.example.domain.model

data class CardInfo(
    val cardScheme: String,
    val cardType: String,
    val bankName: String,
    val countryName: String,
    val cardNumberLength: String,
    val isPrepaid: Boolean
)

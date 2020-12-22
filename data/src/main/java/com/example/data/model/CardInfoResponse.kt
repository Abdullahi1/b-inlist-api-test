package com.example.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CardInfoResponse(
    @Json(name = "bank")
    val bank: Bank,
    @Json(name = "country")
    val country: Country,
    @Json(name = "number")
    val number: Number,
    @Json(name = "prepaid")
    val prepaid: Boolean?,
    @Json(name = "scheme")
    val scheme: String?,
    @Json(name = "type")
    val type: String?
) {
    @JsonClass(generateAdapter = true)
    data class Bank(
        @Json(name = "name")
        val name: String?,
    )

    @JsonClass(generateAdapter = true)
    data class Country(
        @Json(name = "name")
        val name: String?,
    )

    @JsonClass(generateAdapter = true)
    data class Number(
        @Json(name = "length")
        val length: Int?,
    )
}

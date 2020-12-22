package com.example.data.api

import com.example.data.model.CardInfoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("{card_number}")
    suspend fun fetchCardInfo(
        @Path("card_number") cardNumber: String
    ): CardInfoResponse
}
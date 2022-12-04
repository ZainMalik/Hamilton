package com.zain.hamiltonkotlin

import com.zain.hamiltonkotlin.model.CurrencyRatesResponse
import retrofit2.http.GET

interface APIService {

    @GET("USD")
    suspend fun getCurrencyRates(): CurrencyRatesResponse
}
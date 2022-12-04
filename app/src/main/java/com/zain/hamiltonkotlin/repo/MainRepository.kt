package com.zain.hamiltonkotlin.repo

import android.content.Context
import com.zain.hamiltonkotlin.APIService
import com.zain.hamiltonkotlin.model.CurrencyRatesResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class MainRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val apiService: APIService
) {

    private val _currencyRatesSharedFlow = MutableSharedFlow<CurrencyRatesResponse>(extraBufferCapacity = 10)
    val currencyRatesSharedFlow = _currencyRatesSharedFlow.asSharedFlow()


    suspend fun fetchCurrencyRates() = suspendCoroutine<CurrencyRatesResponse> { continuation ->
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getCurrencyRates()
            _currencyRatesSharedFlow.tryEmit(response)
        }
    }



}
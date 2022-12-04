package com.zain.hamiltonkotlin.repo

import android.content.Context
import android.net.Uri
import android.util.Log
import com.zain.hamiltonkotlin.APIService
import com.zain.hamiltonkotlin.CurrencyRatesResponse
import com.zain.hamiltonkotlin.DataState
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.lang.Exception
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
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
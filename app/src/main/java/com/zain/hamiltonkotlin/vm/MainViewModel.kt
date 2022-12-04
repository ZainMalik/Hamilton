package com.zain.hamiltonkotlin.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.zain.hamiltonkotlin.CurrencyRatesResponse
import com.zain.hamiltonkotlin.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _currencyRatesStateFlow = MutableStateFlow<CurrencyRatesResponse?>(null)
    val currencyRatesStateFlow = _currencyRatesStateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            mainRepository.currencyRatesSharedFlow.collect{
                _currencyRatesStateFlow.emit(it)
            }
        }
    }

    fun retrieveCurrencyRates() {
        viewModelScope.launch {
            val currencyRates = mainRepository.fetchCurrencyRates()
            _currencyRatesStateFlow.update { currencyRates }
        }
    }

//    val retrieveCurrencyRates = liveData(Dispatchers.IO) {
//        val retriever = mainRepository.fetchCurrencyRates()
//
//        emit(retriever)
//    }
}
package com.zain.hamiltonkotlin.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zain.hamiltonkotlin.model.CurrencyRatesResponse
import com.zain.hamiltonkotlin.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
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
}
package com.example.capstoneproject.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.domain.model.availableBook.AvailableBook
import com.example.capstoneproject.domain.model.orderBook.OrderBook
import com.example.capstoneproject.domain.model.ticker.Ticker
import com.example.capstoneproject.domain.useCases.GetAvailableBooksUseCase
import com.example.capstoneproject.domain.useCases.GetOrderBookUseCase
import com.example.capstoneproject.domain.useCases.GetTickerUseCase
import com.example.capstoneproject.utils.Constants
import com.example.capstoneproject.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val getAvailableBooksUseCase: GetAvailableBooksUseCase,
    private val getTickerUseCase: GetTickerUseCase,
    private val getOrderBookUseCase: GetOrderBookUseCase
) : ViewModel() {


    private var _availableBooks = MutableLiveData<ResultState<List<AvailableBook>>>()
    val availableBooks: LiveData<ResultState<List<AvailableBook>>> = _availableBooks

    private var _ticker = MutableLiveData<ResultState<Ticker>>()
    val ticker: LiveData<ResultState<Ticker>> = _ticker

    private var _orderBook = MutableLiveData<ResultState<OrderBook>>()
    val orderBook: LiveData<ResultState<OrderBook>> = _orderBook

    fun clearDetail() {
        _ticker.value = ResultState.Loading()
        _orderBook.value = ResultState.Loading()
    }

    fun getAvailableBooks(networkStatus:Boolean) = viewModelScope.launch {
        _availableBooks.postValue(ResultState.Loading())
        try {
            _availableBooks.postValue(ResultState.Success(getAvailableBooksUseCase(networkStatus)))
        } catch (e: Exception) {
            _availableBooks.postValue(ResultState.Error(message = Constants.ERROR_AVAILABLE_BOOK))
        }
    }


    fun getTicker(book: String,networkStatus:Boolean) = viewModelScope.launch {
        try {
            _ticker.postValue(ResultState.Success(getTickerUseCase(book,networkStatus)))
        } catch (e: Exception) {
            _ticker.postValue(ResultState.Error(message =Constants.ERROR_TICKER))
        }
    }

    fun getOrderBook(book: String,networkStatus:Boolean) = viewModelScope.launch {
        try {
            _orderBook.postValue(ResultState.Success(getOrderBookUseCase(book,networkStatus)))
        } catch (e: Exception) {
            _ticker.postValue(ResultState.Error(message = Constants.ERROR_ORDER_BOOK))
        }
    }


}
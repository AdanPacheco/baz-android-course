package com.example.capstoneproject.data.network

import com.example.capstoneproject.data.model.availableBooks.AvailableBookModel
import com.example.capstoneproject.data.model.orderBook.OrderBookModel
import com.example.capstoneproject.data.model.ticker.TickerResponse
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BitsoApiClient @Inject constructor(private val apiService: BitsoService) {

    suspend fun getAvailableBooks(): List<AvailableBookModel> = withContext(Dispatchers.IO) {
        val response = apiService.getAllAvailableBooks()
        response.body()?.payload ?: emptyList()
    }

    fun getTicker(book: String): Single<TickerResponse> = apiService.getTicker(book)

    suspend fun getOrderBook(book: String): OrderBookModel = withContext(Dispatchers.IO) {
        val response = apiService.getOrderBook(book)
        response.body()?.payload ?: OrderBookModel()
    }
}

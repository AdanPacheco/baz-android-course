package com.example.capstoneproject.data.network

import com.example.capstoneproject.data.model.availableBooks.AvailableBookModel
import com.example.capstoneproject.data.model.orderBook.OrderBookModel
import com.example.capstoneproject.data.model.ticker.TickerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BitsoApiClient @Inject constructor(private val apiService: BitsoService) {


    suspend fun getAvailableBooks(): List<AvailableBookModel> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getAllAvailableBooks()
            response.body()?.payload ?: emptyList()
        }
    }

    suspend fun getTicker(book: String): TickerModel {
        return withContext(Dispatchers.IO) {
            val response = apiService.getTicker(book)
            response.body()?.payload ?: TickerModel()
        }
    }

    suspend fun getOrderBook(book: String): OrderBookModel {
        return withContext(Dispatchers.IO) {
            val response = apiService.getOrderBook(book)
            response.body()?.payload ?: OrderBookModel()
        }
    }
}
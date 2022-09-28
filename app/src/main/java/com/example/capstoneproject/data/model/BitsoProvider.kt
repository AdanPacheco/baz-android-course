package com.example.capstoneproject.data.model

import com.example.capstoneproject.data.model.availableBooks.AvailableBookModel
import com.example.capstoneproject.data.model.orderBook.OrderBookModel
import com.example.capstoneproject.data.model.ticker.TickerModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BitsoProvider @Inject constructor() {
    companion object {
        var availableBooks: List<AvailableBookModel> = emptyList()
    }
}
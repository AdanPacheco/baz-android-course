package com.example.capstoneproject.data

import com.example.capstoneproject.data.database.dao.BitsoDao
import com.example.capstoneproject.data.database.entities.availableBooksEntities.AvailableBookEntity
import com.example.capstoneproject.data.database.entities.orderBookEntities.OrderBookEntity
import com.example.capstoneproject.data.database.entities.tickerEntities.TickerEntity
import com.example.capstoneproject.data.network.BitsoApiClient
import com.example.capstoneproject.domain.model.availableBook.AvailableBook
import com.example.capstoneproject.domain.model.availableBook.toDomain
import com.example.capstoneproject.domain.model.orderBook.OrderBook
import com.example.capstoneproject.domain.model.orderBook.toDomain
import com.example.capstoneproject.domain.model.ticker.Ticker
import com.example.capstoneproject.domain.model.ticker.toDomain
import javax.inject.Inject

class BitsoRepository @Inject constructor(
    private val api: BitsoApiClient,
    private val bitsoDao: BitsoDao
) {


    suspend fun getAllAvailableBooksFromApi(): List<AvailableBook> {
        val response = api.getAvailableBooks()
        return response.map { it.toDomain() }
    }

    suspend fun getAllAvailableBooksFromDatabase(): List<AvailableBook> {
        val response = bitsoDao.getAllAvailableBooks()
        return response.map { it.toDomain() }
    }

    suspend fun insertAllAvailableBooksToDatabase(availableBooks: List<AvailableBookEntity>) {
        bitsoDao.insertAllAvailableBooks(availableBooks)
    }

    suspend fun getTickerFromApi(book: String): Ticker {
        val response = api.getTicker(book)
        return response.toDomain()
    }

    suspend fun getTickerFromDatabase(book: String): Ticker {
        val response = bitsoDao.getTicker(book)
        return response.toDomain()
    }

    suspend fun insertTickerToDatabase(ticker: TickerEntity) {
        bitsoDao.insertTicker(ticker)
    }

    suspend fun getOrderBookFromApi(book: String): OrderBook {
        val response = api.getOrderBook(book)
        return response.toDomain()
    }

    suspend fun getOrderBookFromDatabase(book: String): OrderBook {
        val response = bitsoDao.getOrderBook(book)
        return response.toDomain()
    }

    suspend fun insertOrderBookToDatabase(orderBook: OrderBookEntity) {
        bitsoDao.insertOrderBook(orderBook)
    }


}
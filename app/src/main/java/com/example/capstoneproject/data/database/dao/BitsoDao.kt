package com.example.capstoneproject.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.capstoneproject.data.database.entities.availableBooksEntities.AvailableBookEntity
import com.example.capstoneproject.data.database.entities.orderBookEntities.OrderBookEntity
import com.example.capstoneproject.data.database.entities.tickerEntities.TickerEntity

@Dao
interface BitsoDao {

    @Query("SELECT * FROM available_book_table")
    suspend fun getAllAvailableBooks(): List<AvailableBookEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllAvailableBooks(books: List<AvailableBookEntity>)

    @Query("SELECT * FROM ticker_table where book = :book")
    suspend fun getTicker(book: String): TickerEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTicker(ticker: TickerEntity)

    @Query("SELECT * FROM order_book_table where book = :book")
    suspend fun getOrderBook(book: String): OrderBookEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderBook(book: OrderBookEntity)


}
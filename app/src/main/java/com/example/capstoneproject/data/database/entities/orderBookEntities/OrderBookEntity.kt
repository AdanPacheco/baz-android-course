package com.example.capstoneproject.data.database.entities.orderBookEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.capstoneproject.domain.model.orderBook.OrderBook

@Entity(tableName = "order_book_table")

data class OrderBookEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "book")
    val book: String = "",
    @ColumnInfo(name = "asks") val asks: List<AskEntity> = emptyList(),
    @ColumnInfo(name = "bids") val bids: List<BidEntity> = emptyList()
)

fun OrderBook.toDatabase(book: String) = OrderBookEntity(book = book, asks = asks.map { it.toDatabase() }, bids = bids.map { it.toDatabase() })

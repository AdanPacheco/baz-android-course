package com.example.capstoneproject.data.database.entities.tickerEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.capstoneproject.domain.model.ticker.Ticker

@Entity(tableName = "ticker_table")
data class TickerEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "book")
    val book: String = "",
    @ColumnInfo(name = "high") val high: String = "",
    @ColumnInfo(name = "last") val last: String = "",
    @ColumnInfo(name = "low") val low: String = ""
)

fun Ticker.toDatabase() = TickerEntity(book = book, high = high, last = last, low = low)

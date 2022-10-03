package com.example.capstoneproject.domain.model.ticker

import com.example.capstoneproject.data.database.entities.tickerEntities.TickerEntity
import com.example.capstoneproject.data.model.ticker.TickerModel

data class Ticker(
    val book: String = "",
    val high: String = "",
    val last: String = "",
    val low: String = ""
)

fun TickerModel.toDomain() = Ticker(book = book, high = high, last = last, low = low)
fun TickerEntity.toDomain() = Ticker(book = book, high = high, last = last, low = low)

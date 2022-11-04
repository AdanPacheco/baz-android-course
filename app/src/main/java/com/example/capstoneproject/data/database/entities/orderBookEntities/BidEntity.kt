package com.example.capstoneproject.data.database.entities.orderBookEntities

import com.example.capstoneproject.domain.model.orderBook.Bid

data class BidEntity(
    val amount: String,
    val book: String,
    val price: String
)

fun Bid.toDatabase() = BidEntity(amount = amount, book = book, price = price)

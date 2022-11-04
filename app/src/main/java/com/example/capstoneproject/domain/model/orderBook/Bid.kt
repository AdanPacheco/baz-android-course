package com.example.capstoneproject.domain.model.orderBook

import com.example.capstoneproject.data.database.entities.orderBookEntities.BidEntity
import com.example.capstoneproject.data.model.orderBook.BidModel

data class Bid(
    val amount: String,
    val book: String,
    val price: String
)

fun BidModel.toDomain() = Bid(amount = amount, book = book, price = price)
fun BidEntity.toDomain() = Bid(amount = amount, book = book, price = price)
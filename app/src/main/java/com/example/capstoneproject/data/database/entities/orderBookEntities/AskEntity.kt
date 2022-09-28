package com.example.capstoneproject.data.database.entities.orderBookEntities

import com.example.capstoneproject.domain.model.orderBook.Ask

data class AskEntity(
    val amount: String,
    val book: String,
    val price: String
)

fun Ask.toDatabase() = AskEntity(amount = amount, book = book, price = price)
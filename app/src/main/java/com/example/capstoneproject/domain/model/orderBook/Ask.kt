package com.example.capstoneproject.domain.model.orderBook

import com.example.capstoneproject.data.database.entities.orderBookEntities.AskEntity
import com.example.capstoneproject.data.model.orderBook.AskModel

data class Ask(
    val amount: String,
    val book: String,
    val price: String
)

fun AskModel.toDomain() = Ask(amount = amount, book = book, price = price)
fun AskEntity.toDomain() = Ask(amount = amount, book = book, price = price)
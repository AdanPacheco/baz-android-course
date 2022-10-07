package com.example.capstoneproject.domain.model.orderBook

import com.example.capstoneproject.data.database.entities.orderBookEntities.OrderBookEntity
import com.example.capstoneproject.data.model.orderBook.OrderBookModel

data class OrderBook(
    val asks: List<Ask> = emptyList(),
    val bids: List<Bid> = emptyList()
)

fun OrderBookModel.toDomain() = OrderBook(asks = asks.map { it.toDomain() }, bids = bids.map { it.toDomain() })
fun OrderBookEntity.toDomain() = OrderBook(asks = asks.map { it.toDomain() }, bids = bids.map { it.toDomain() })

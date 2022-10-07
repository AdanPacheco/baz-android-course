package com.example.capstoneproject.domain.useCases

import com.example.capstoneproject.data.BitsoRepository
import com.example.capstoneproject.data.database.entities.orderBookEntities.toDatabase
import com.example.capstoneproject.domain.model.orderBook.OrderBook
import javax.inject.Inject

class GetOrderBookUseCase @Inject constructor(private val repository: BitsoRepository) {

    suspend operator fun invoke(book: String,networkStatus:Boolean): OrderBook {

        return if (networkStatus) {
            val orderBook = repository.getOrderBookFromApi(book)
            repository.insertOrderBookToDatabase(orderBook = orderBook.toDatabase(book))
            orderBook
        } else {
            repository.getOrderBookFromDatabase(book)
        }
    }
}
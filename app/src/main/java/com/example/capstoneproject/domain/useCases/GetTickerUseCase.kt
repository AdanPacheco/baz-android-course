package com.example.capstoneproject.domain.useCases

import com.example.capstoneproject.data.BitsoRepository
import com.example.capstoneproject.data.database.entities.tickerEntities.toDatabase
import com.example.capstoneproject.domain.model.ticker.Ticker
import javax.inject.Inject

class GetTickerUseCase @Inject constructor(private val repository: BitsoRepository) {

    suspend operator fun invoke(book: String, networkStatus: Boolean): Ticker {

        return if (networkStatus) {
            val ticker = repository.getTickerFromApi(book)
            repository.insertTickerToDatabase(ticker.toDatabase())
            ticker
        } else {
            repository.getTickerFromDatabase(book)
        }
    }
}
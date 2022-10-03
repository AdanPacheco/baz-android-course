package com.example.capstoneproject.domain.useCases

import com.example.capstoneproject.data.BitsoRepository
import com.example.capstoneproject.domain.model.ticker.Ticker
import javax.inject.Inject

class GetTickerUseCaseDatabase @Inject constructor(private val repository: BitsoRepository) {

    suspend operator fun invoke(book: String): Ticker {
        return repository.getTickerFromDatabase(book)
    }
}

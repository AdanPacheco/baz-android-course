package com.example.capstoneproject.domain.useCases

import com.example.capstoneproject.data.BitsoRepository
import com.example.capstoneproject.data.database.entities.availableBooksEntities.toDatabase
import com.example.capstoneproject.domain.model.availableBook.AvailableBook
import javax.inject.Inject

class GetAvailableBooksUseCase @Inject constructor(private val repository: BitsoRepository) {

    suspend operator fun invoke(networkStatus: Boolean): List<AvailableBook> {
        return if (networkStatus) {
            val availableBooks = repository.getAllAvailableBooksFromApi()
            repository.insertAllAvailableBooksToDatabase(availableBooks = availableBooks.map { it.toDatabase() })
            availableBooks
        } else {
            repository.getAllAvailableBooksFromDatabase()
        }
    }
}

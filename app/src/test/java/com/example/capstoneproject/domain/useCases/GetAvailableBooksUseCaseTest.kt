package com.example.capstoneproject.domain.useCases

import com.example.capstoneproject.data.BitsoRepository
import com.example.capstoneproject.domain.model.availableBook.AvailableBook
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetAvailableBooksUseCaseTest{

    @RelaxedMockK
    private lateinit var repository: BitsoRepository
    private lateinit var getAvailableBooksUseCase: GetAvailableBooksUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getAvailableBooksUseCase = GetAvailableBooksUseCase(repository)
    }

    @Test
    fun `when the network connection is not available then get available books from database`() = runBlocking {
        val availableBookList:List<AvailableBook> = listOf()
        //Given
        coEvery { repository.getAllAvailableBooksFromDatabase() } returns availableBookList

        //When
        val result = getAvailableBooksUseCase(false)

        //Then
        coVerify(exactly = 0) { repository.getAllAvailableBooksFromApi() }
        coVerify(exactly = 0) { repository.insertAllAvailableBooksToDatabase(any())}
        coVerify(exactly = 1) { repository.getAllAvailableBooksFromDatabase() }
        assert(availableBookList==result)
    }

    @Test
    fun `when the network connection is available then get available books from api and save it to database`() = runBlocking {
        val availableBookList:List<AvailableBook> = listOf()
        //Given
        coEvery { repository.getAllAvailableBooksFromApi() } returns availableBookList

        //When
        val result = getAvailableBooksUseCase(true)

        //Then
        coVerify(exactly = 1) { repository.getAllAvailableBooksFromApi() }
        coVerify(exactly = 1) { repository.insertAllAvailableBooksToDatabase(any()) }
        coVerify(exactly = 0) { repository.getAllAvailableBooksFromDatabase() }
        assert(availableBookList==result)
    }
}
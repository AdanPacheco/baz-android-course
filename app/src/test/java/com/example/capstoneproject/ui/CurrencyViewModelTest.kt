package com.example.capstoneproject.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.capstoneproject.data.BitsoRepository
import com.example.capstoneproject.domain.model.availableBook.AvailableBook
import com.example.capstoneproject.domain.useCases.GetAvailableBooksUseCase
import com.example.capstoneproject.domain.useCases.GetOrderBookUseCase
import com.example.capstoneproject.domain.useCases.GetTickerUseCaseDatabase
import com.example.capstoneproject.ui.viewmodel.CurrencyViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CurrencyViewModelTest {

    @RelaxedMockK
    private lateinit var getAvailableBooksUseCase: GetAvailableBooksUseCase

    @RelaxedMockK
    private lateinit var getTickerUseCase: GetTickerUseCaseDatabase

    @RelaxedMockK
    private lateinit var getOrderBookUseCase: GetOrderBookUseCase

    @RelaxedMockK
    private lateinit var repository: BitsoRepository

    private lateinit var currencyViewModel: CurrencyViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        currencyViewModel = CurrencyViewModel(
            getAvailableBooksUseCase,
            getTickerUseCase,
            getOrderBookUseCase,
            repository
        )
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when getAllAvailableUseCase call return a list of available Books set on livedata`() = runTest {
        val availableBookList: List<AvailableBook> = listOf()
        coEvery { getAvailableBooksUseCase(true) } returns availableBookList

        currencyViewModel.getAvailableBooks(true)

        assert(currencyViewModel.availableBooks.value?.data == availableBookList)
    }
}

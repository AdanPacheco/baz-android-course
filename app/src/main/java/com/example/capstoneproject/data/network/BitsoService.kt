package com.example.capstoneproject.data.network

import com.example.capstoneproject.data.model.availableBooks.AvailableBooksResponse
import com.example.capstoneproject.data.model.orderBook.OrderBookResponse
import com.example.capstoneproject.data.model.ticker.TickerResponse
import com.example.capstoneproject.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BitsoService {

    @GET(Constants.URL_AVAILABLE_BOOKS)
    suspend fun getAllAvailableBooks(): Response<AvailableBooksResponse>

    @GET(Constants.URL_TICKER)
    suspend fun getTicker(@Query("book") book:String): Response<TickerResponse>

    @GET(Constants.URL_ORDER_BOOK)
    suspend fun getOrderBook(@Query("book") book:String): Response<OrderBookResponse>

}
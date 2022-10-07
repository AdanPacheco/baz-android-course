package com.example.capstoneproject.domain.model.availableBook

import android.os.Parcelable
import com.example.capstoneproject.data.database.entities.availableBooksEntities.AvailableBookEntity
import com.example.capstoneproject.data.model.availableBooks.AvailableBookModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class AvailableBook(
    val book: String,
    val maximum_price: String,
):Parcelable

fun AvailableBookModel.toDomain() = AvailableBook(book = book, maximum_price = maximum_price)
fun AvailableBookEntity.toDomain() = AvailableBook(book = book, maximum_price = maximum_price)
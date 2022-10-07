package com.example.capstoneproject.data.database.entities.availableBooksEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.capstoneproject.domain.model.availableBook.AvailableBook

@Entity(tableName = "available_book_table")
data class AvailableBookEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "book") val book: String,
    @ColumnInfo(name = "maximum_price") val maximum_price: String,
)


fun AvailableBook.toDatabase() = AvailableBookEntity(book = book, maximum_price = maximum_price)
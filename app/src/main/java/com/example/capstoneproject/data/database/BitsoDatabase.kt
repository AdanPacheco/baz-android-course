package com.example.capstoneproject.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.capstoneproject.data.database.dao.BitsoDao
import com.example.capstoneproject.data.database.entities.availableBooksEntities.AvailableBookEntity
import com.example.capstoneproject.data.database.entities.orderBookEntities.OrderBookEntity
import com.example.capstoneproject.data.database.entities.tickerEntities.TickerEntity
import com.example.capstoneproject.utils.roomConverter.Converters

@Database(
    entities =
    [
        AvailableBookEntity::class,
        OrderBookEntity::class,
        TickerEntity::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class BitsoDatabase : RoomDatabase() {

    abstract fun getBitsoDao(): BitsoDao
}

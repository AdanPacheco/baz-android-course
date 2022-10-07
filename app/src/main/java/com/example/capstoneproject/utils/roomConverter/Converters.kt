package com.example.capstoneproject.utils.roomConverter

import androidx.room.TypeConverter
import com.example.capstoneproject.data.database.entities.orderBookEntities.AskEntity
import com.example.capstoneproject.data.database.entities.orderBookEntities.BidEntity
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun askListToJson(value: List<AskEntity>): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun askJsonToList(value: String): List<AskEntity>? {
        return Gson().fromJson(value, Array<AskEntity>::class.java)?.toList()
    }

    @TypeConverter
    fun bidListToJson(value: List<BidEntity>): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun bidJsonToList(value: String): List<BidEntity>? {
        return Gson().fromJson(value, Array<BidEntity>::class.java)?.toList()
    }
}

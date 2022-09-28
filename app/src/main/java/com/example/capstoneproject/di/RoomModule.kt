package com.example.capstoneproject.di

import android.content.Context
import androidx.room.Room
import com.example.capstoneproject.data.database.BitsoDatabase
import com.example.capstoneproject.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun privideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context, BitsoDatabase::class.java, Constants.NAME_DATABASE).build()

    @Singleton
    @Provides
    fun providesBitsoDao(db: BitsoDatabase) = db.getBitsoDao()
}
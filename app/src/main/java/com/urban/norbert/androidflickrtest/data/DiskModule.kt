package com.urban.norbert.androidflickrtest.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DiskModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "images_database").build()

    @Provides
    @Singleton
    fun provideImageDao(imagesDatabase: AppDatabase) =
        imagesDatabase.imageDao()

    @Provides
    @Singleton
    fun provideQueryDao(imagesDatabase: AppDatabase) =
        imagesDatabase.queryDao()
}
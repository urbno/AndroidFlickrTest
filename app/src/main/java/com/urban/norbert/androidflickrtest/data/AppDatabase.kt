package com.urban.norbert.androidflickrtest.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.urban.norbert.androidflickrtest.ui.util.BitmapConverter

@Database(entities = [ImageEntity::class], version = 1, exportSchema = false)
@TypeConverters(BitmapConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun imageDao(): ImageDao
}
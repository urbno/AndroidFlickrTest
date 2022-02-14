package com.urban.norbert.androidflickrtest.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ImageDao {

    @Query("SELECT * FROM images LIMIT 20")
    suspend fun getSavedImages(): List<ImageEntity>
}
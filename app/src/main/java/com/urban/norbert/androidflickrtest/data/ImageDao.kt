package com.urban.norbert.androidflickrtest.data

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDao {

    @Query("SELECT * FROM images LIMIT 20")
    fun getSavedImages(): PagingSource<Int, ImageEntity>

    @Query("SELECT * FROM images WHERE imageId = :imageId")
    fun getSpecificImage(imageId: String): Flow<ImageEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(vararg cocktails: ImageEntity)

    @Query("DELETE FROM images WHERE imageId = :imageId")
    suspend fun deleteImage(imageId: String)

    @Query("DELETE FROM images")
    suspend fun deleteAllImages()
}
package com.urban.norbert.androidflickrtest.data

import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.urban.norbert.androidflickrtest.model.Photo
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDao {

    @Query("SELECT * FROM images LIMIT 20")
    fun getSavedImages(): PagingSource<Int, ImageEntity>

    @Query("SELECT * FROM images WHERE imageId = :imageId")
    suspend fun getSpecificImage(imageId: String): ImageEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(vararg imageEntity: ImageEntity)

    @Query("DELETE FROM images WHERE imageId = :imageId")
    suspend fun deleteImage(imageId: String)

    @Query("DELETE FROM images")
    suspend fun deleteAllImages()
}
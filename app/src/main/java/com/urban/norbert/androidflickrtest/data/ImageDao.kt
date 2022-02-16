package com.urban.norbert.androidflickrtest.data

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImageDao {

    @Query("SELECT * FROM images LIMIT 20")
    fun getSavedImages(): PagingSource<Int, ImageEntity>

    @Query("SELECT * FROM images WHERE idImage = :idImage")
    suspend fun getSpecificImage(idImage: String): ImageEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(vararg cocktails: ImageEntity)

    @Query("DELETE FROM images WHERE idImage = :idImage")
    suspend fun deleteImage(idImage: String)

    @Query("DELETE FROM images")
    suspend fun deleteAllImages()
}
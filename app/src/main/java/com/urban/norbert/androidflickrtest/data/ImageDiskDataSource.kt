package com.urban.norbert.androidflickrtest.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageDiskDataSource @Inject constructor(
    private val imageDao: ImageDao,
    private val queryDao: QueryDao
) {

    fun getSavedImages() =
        imageDao.getSavedImages()

    suspend fun getImageById(imageId: String) =
        imageDao.getSpecificImage(imageId)

    suspend fun insertImage(imageEntity: ImageEntity) =
        imageDao.insertImages()

    suspend fun deleteAllImages() =
        imageDao.deleteAllImages()

    fun getQuery() =
        queryDao.getQuery()

    suspend fun insertQuery(query: QueryEntity) =
        queryDao.insertQuery(query)

    suspend fun deleteQuery() =
        queryDao.deleteQuery()

    suspend fun isQueryAvailable() =
        queryDao.count()
}
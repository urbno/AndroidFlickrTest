package com.urban.norbert.androidflickrtest.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageDiskDataSource @Inject constructor(
    private val imageDao: ImageDao
) {
    suspend fun getImageById(imageId: String) =
        imageDao.getSpecificImage(imageId)

    suspend fun insertImage(imageEntity: ImageEntity) =
        imageDao.insertImages()

    suspend fun deleteAllImages() =
        imageDao.deleteAllImages()
}
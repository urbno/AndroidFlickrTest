package com.urban.norbert.androidflickrtest.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageDiskDataSource @Inject constructor(
    private val imageDao: ImageDao
) {
    fun getImageById(imageId: String) =
        imageDao.getSpecificImage(imageId)
}
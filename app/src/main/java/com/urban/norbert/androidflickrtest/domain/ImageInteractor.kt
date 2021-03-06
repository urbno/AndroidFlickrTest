package com.urban.norbert.androidflickrtest.domain

import com.urban.norbert.androidflickrtest.data.ImageDiskDataSource
import com.urban.norbert.androidflickrtest.data.QueryEntity
import com.urban.norbert.androidflickrtest.network.ImageNetworkDataSource
import javax.inject.Inject

class ImageInteractor @Inject constructor(
    private val networkDataSource: ImageNetworkDataSource,
    private val diskDataSource: ImageDiskDataSource
) {

    // region networkDataSource

    fun getImagesByTags(tags: String) =
        networkDataSource.getImagesByTags(tags = tags)

    suspend fun getImageDetailsById(imageId: String, secret: String) =
        networkDataSource.getImageDetailsById(imageId = imageId, secret = secret)

    // endregion

    // region diskDataSource

    fun getSavedImages() =
        diskDataSource.getSavedImages()

    suspend fun getImageById(imageId: String) =
        diskDataSource.getImageById(imageId = imageId)

    suspend fun deleteAllImages() =
        diskDataSource.deleteAllImages()

    fun getQuery() =
        diskDataSource.getQuery()

    suspend fun isQueryAvailable() =
        diskDataSource.isQueryAvailable()

    suspend fun insertQuery(query: QueryEntity) =
        diskDataSource.insertQuery(query)

    suspend fun deleteQuery() =
        diskDataSource.deleteQuery()

    // endregion
}
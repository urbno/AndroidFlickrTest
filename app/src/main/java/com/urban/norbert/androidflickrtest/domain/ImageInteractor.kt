package com.urban.norbert.androidflickrtest.domain

import com.urban.norbert.androidflickrtest.data.ImageDiskDataSource
import com.urban.norbert.androidflickrtest.network.ImageNetworkDataSource
import javax.inject.Inject

class ImageInteractor @Inject constructor(
    private val networkDataSource: ImageNetworkDataSource,
    private val diskDataSource: ImageDiskDataSource
) {

    // region networkDataSource

    fun getImagesByTags(tags: String) =
        networkDataSource.getImagesByTags(tags = tags)

    // endregion

    // region diskDataSource

    fun getImageById(imageId: String) =
        diskDataSource.getImageById(imageId = imageId)

    // endregion
}
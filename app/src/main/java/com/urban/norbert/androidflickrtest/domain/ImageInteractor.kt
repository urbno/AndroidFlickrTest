package com.urban.norbert.androidflickrtest.domain

import com.urban.norbert.androidflickrtest.data.ImageDiskDataSource
import com.urban.norbert.androidflickrtest.network.ImageNetworkDataSource
import javax.inject.Inject

class ImageInteractor @Inject constructor(
    private val networkDataSource: ImageNetworkDataSource,
    private val diskDataSource: ImageDiskDataSource
) {

    // region networkDataSource

    suspend fun getImagesByTags(tags: String, pageNum: Int) =
        networkDataSource.getImagesByTags(tags = tags, pageNum = pageNum)

    // endregion

    // region diskDataSource

    // endregion
}
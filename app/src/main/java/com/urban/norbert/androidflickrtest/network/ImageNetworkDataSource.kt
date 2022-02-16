package com.urban.norbert.androidflickrtest.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageNetworkDataSource @Inject constructor(
    private val searchApi: SearchApi
) {

    suspend fun getImagesByTags(tags: String, pageNum: Int) =
        searchApi.searchImagesByTags(tags = tags, page = pageNum.toString())
}
package com.urban.norbert.androidflickrtest.network

import androidx.paging.*
import com.urban.norbert.androidflickrtest.ui.main.paging.ImagesPagingSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageNetworkDataSource @Inject constructor(
    private val searchApi: SearchApi
) {

    fun getImagesByTags(tags: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 60,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                ImagesPagingSource(searchApi, tags)
            }
        ).flow
}
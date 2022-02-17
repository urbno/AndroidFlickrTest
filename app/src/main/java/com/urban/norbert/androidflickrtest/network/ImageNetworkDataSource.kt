package com.urban.norbert.androidflickrtest.network

import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.urban.norbert.androidflickrtest.data.ImageDao
import com.urban.norbert.androidflickrtest.ui.main.paging.ImagesPagingSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageNetworkDataSource @Inject constructor(
    private val searchApi: SearchApi,
    private val imageDao: ImageDao,
    private val context: Context
) {

    fun getImagesByTags(tags: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 60,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                ImagesPagingSource(
                    searchApi = searchApi,
                    imageDao = imageDao,
                    query = tags,
                    context = context
                )
            }
        ).flow
}
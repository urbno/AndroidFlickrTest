package com.urban.norbert.androidflickrtest.ui.main.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.urban.norbert.androidflickrtest.model.ImagesData
import com.urban.norbert.androidflickrtest.model.Photo
import com.urban.norbert.androidflickrtest.model.Photos
import com.urban.norbert.androidflickrtest.network.ImageNetworkDataSource
import com.urban.norbert.androidflickrtest.network.SearchApi
import retrofit2.HttpException
import java.io.IOException

private const val IMAGES_STARTING_PAGE_INDEX = 1

class ImagesPagingSource(
    private val searchApi: SearchApi,
    private val query: String
) : PagingSource<Int, Photo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val page = params.key ?: IMAGES_STARTING_PAGE_INDEX
            val response = searchApi.searchImagesByTags(tags = query, page = page.toString())
            val images = response.photos.photo
            LoadResult.Page(
                data = images,
                prevKey = if (page == IMAGES_STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (images.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
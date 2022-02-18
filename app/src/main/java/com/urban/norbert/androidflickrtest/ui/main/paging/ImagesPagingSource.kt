package com.urban.norbert.androidflickrtest.ui.main.paging

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.urban.norbert.androidflickrtest.data.ImageDao
import com.urban.norbert.androidflickrtest.model.Photo
import com.urban.norbert.androidflickrtest.network.SearchApi
import com.urban.norbert.androidflickrtest.ui.util.ItemConverter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

private const val IMAGES_STARTING_PAGE_INDEX = 1

class ImagesPagingSource(
    private val searchApi: SearchApi,
    private val imageDao: ImageDao,
    private val query: String,
    private val context: Context
) : PagingSource<Int, Photo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val page = params.key ?: IMAGES_STARTING_PAGE_INDEX
            val response = searchApi.searchImagesByTags(tags = query, page = page.toString())
            val images = response.photos.photo
            images.forEach {
                CoroutineScope(Dispatchers.IO).launch {
                    if (!it.url_h.isNullOrEmpty()) {
                        val convertedItem = ItemConverter.modelToEntity(it)
                        Glide.with(context)
                            .load(it.url_h.replace("\\/", "/"))
                            .into(object : CustomTarget<Drawable>() {
                                override fun onResourceReady(
                                    resource: Drawable,
                                    transition: Transition<in Drawable>?
                                ) {
                                    convertedItem.image = (resource as BitmapDrawable).bitmap
                                    CoroutineScope(Dispatchers.IO).launch {
//                                        searchApi.searchDetailsByPhotoId(
//                                            photo_id = it.id,
//                                            secret = it.secret
//                                        ).description?._content.also { convertedItem.description = it }
                                        imageDao.insertImages(convertedItem)
                                    }
                                }

                                override fun onLoadCleared(placeholder: Drawable?) {}
                            })
                    }
                }
            }
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
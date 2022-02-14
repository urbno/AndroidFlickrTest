package com.urban.norbert.androidflickrtest.network

import com.urban.norbert.androidflickrtest.BuildConfig
import com.urban.norbert.androidflickrtest.model.ImageData
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("")
    suspend fun searchImageByName(
        @Query("method") method: String = "flickr.photos.search",
        @Query("api_key") api_key: String = BuildConfig.FLICKR_KEY,
        @Query("tags") tags: String,
        @Query("format") format: String = "json",
        @Query("per_page") per_page: String = "20",
        @Query("page") page: String,
        @Query("media") media: String = "photos",
        @Query("extras") extras: String = "url_h",
        @Query("safe_search") safe_search: String = "1",
    ): ImageData
}
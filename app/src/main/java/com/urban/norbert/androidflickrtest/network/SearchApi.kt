package com.urban.norbert.androidflickrtest.network

import com.urban.norbert.androidflickrtest.BuildConfig
import com.urban.norbert.androidflickrtest.model.ImagesData
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("/services/rest/")
    suspend fun searchImageByName(
        @Query("method") method: String = NetworkConfig.METHOD,
        @Query("api_key") apiKey: String = BuildConfig.FLICKR_KEY,
        @Query("tags") tags: String,
        @Query("format") format: String = NetworkConfig.FORMAT,
        @Query("per_page") perPage: String = NetworkConfig.PER_PAGE,
        @Query("page") page: String,
        @Query("media") media: String = NetworkConfig.MEDIA,
        @Query("extras") extras: String = NetworkConfig.EXTRAS,
        @Query("safe_search") safeSearch: String = NetworkConfig.SAFE_SEARCH,
        @Query("nojsoncallback") noJsonCallback: String = NetworkConfig.NO_JSON_CALLBACK,
    ): ImagesData
}
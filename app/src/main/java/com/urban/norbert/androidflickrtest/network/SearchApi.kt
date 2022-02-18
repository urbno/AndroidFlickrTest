package com.urban.norbert.androidflickrtest.network

import com.urban.norbert.androidflickrtest.BuildConfig
import com.urban.norbert.androidflickrtest.model.ImagesData
import com.urban.norbert.androidflickrtest.model.Photo
import com.urban.norbert.androidflickrtest.model.detail.PhotoDetail
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    /**
     * @return List of [ImagesData]
     *
     * @param tags the tags related to the image.
     * @param page the current page of items.
     */
    @GET("/services/rest/")
    suspend fun searchImagesByTags(
        @Query("method") method: String = NetworkConfig.METHOD_PHOTOS_SEARCH,
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

    /**
     *
     */
    @GET("/services/rest/")
    suspend fun searchDetailsByPhotoId(
        @Query("method") method: String = NetworkConfig.METHOD_PHOTO_DETAIL,
        @Query("api_key") apiKey: String = BuildConfig.FLICKR_KEY,
        @Query("photo_id") photo_id: String,
        @Query("secret") secret: String,
        @Query("format") format: String = NetworkConfig.FORMAT,
        @Query("nojsoncallback") noJsonCallback: String = NetworkConfig.NO_JSON_CALLBACK,
    ): PhotoDetail
}
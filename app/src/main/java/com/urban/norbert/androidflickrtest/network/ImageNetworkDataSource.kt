package com.urban.norbert.androidflickrtest.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageNetworkDataSource @Inject constructor(
    private val searchApi: SearchApi
) {

    suspend fun getImageByName(imageName: String, pageNum: Int){
        searchApi.searchImageByName(tags = imageName, page = pageNum.toString())
    }
}
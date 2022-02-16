package com.urban.norbert.androidflickrtest.model

import com.google.gson.annotations.SerializedName

data class ImagesData(
    @SerializedName("photos")
    val photos: Photos,
    @SerializedName("stat")
    val stat: String
)
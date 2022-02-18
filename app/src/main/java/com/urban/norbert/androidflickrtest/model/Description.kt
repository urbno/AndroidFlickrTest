package com.urban.norbert.androidflickrtest.model

import com.google.gson.annotations.SerializedName

data class Description(
    @SerializedName("_content")
    val _content: String
)
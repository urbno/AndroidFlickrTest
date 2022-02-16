package com.urban.norbert.androidflickrtest.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("farm")
    val farm: Int,
    @SerializedName("height_h")
    val height_h: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("isfamily")
    val isfamily: Int,
    @SerializedName("isfriend")
    val isfriend: Int,
    @SerializedName("ispublic")
    val ispublic: Int,
    @SerializedName("owner")
    val owner: String,
    @SerializedName("secret")
    val secret: String,
    @SerializedName("server")
    val server: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url_h")
    val url_h: String,
    @SerializedName("width_h")
    val width_h: Int
)
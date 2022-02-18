package com.urban.norbert.androidflickrtest.ui.util

import com.urban.norbert.androidflickrtest.data.ImageEntity
import com.urban.norbert.androidflickrtest.model.Photo

object ItemConverter {

    fun modelToEntity(photo: Photo) =
        ImageEntity(
            imageDBId = null,
            imageId = photo.id,
            title = photo.title,
            url = photo.url_h,
            image = null,
            description = photo.description?._content
        )
}
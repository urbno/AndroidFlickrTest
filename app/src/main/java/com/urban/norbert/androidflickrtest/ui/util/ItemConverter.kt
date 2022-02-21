package com.urban.norbert.androidflickrtest.ui.util

import com.urban.norbert.androidflickrtest.data.ImageEntity
import com.urban.norbert.androidflickrtest.model.detail.PhotoDetail

object ItemConverter {

    fun modelToEntity(photoDetail: PhotoDetail) =
        ImageEntity(
            imageDBId = null,
            imageId = photoDetail.photo.id,
            title = photoDetail.photo.title._content,
            url = photoDetail.photo.urls.url[0]._content,
            image = null,
            description = photoDetail.photo.description._content
        )
}
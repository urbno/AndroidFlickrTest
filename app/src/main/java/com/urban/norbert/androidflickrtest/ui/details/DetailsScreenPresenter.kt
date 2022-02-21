package com.urban.norbert.androidflickrtest.ui.details

import com.urban.norbert.androidflickrtest.domain.ImageInteractor
import javax.inject.Inject

class DetailsScreenPresenter @Inject constructor(
    private val imageInteractor: ImageInteractor
) {

    // from DB
    suspend fun getImageById(imageId: String) =
        imageInteractor.getImageById(imageId = imageId)

    // from network
    suspend fun getImageDetailsById(imageId: String, secret: String) =
        imageInteractor.getImageDetailsById(imageId = imageId, secret = secret)

}
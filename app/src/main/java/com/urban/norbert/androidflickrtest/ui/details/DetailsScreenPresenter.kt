package com.urban.norbert.androidflickrtest.ui.details

import com.urban.norbert.androidflickrtest.domain.ImageInteractor
import javax.inject.Inject

class DetailsScreenPresenter @Inject constructor(
    private val imageInteractor: ImageInteractor
) {

    fun getImageById(imageId: String) =
        imageInteractor.getImageById(imageId = imageId)

}
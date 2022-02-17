package com.urban.norbert.androidflickrtest.ui.main

import com.urban.norbert.androidflickrtest.domain.ImageInteractor
import javax.inject.Inject

class MainScreenPresenter @Inject constructor(
    private val imageInteractor: ImageInteractor
) {

    fun getImagesByTags(tags: String) =
        imageInteractor.getImagesByTags(tags = tags)

    suspend fun deleteAllImages() =
        imageInteractor.deleteAllImages()
}
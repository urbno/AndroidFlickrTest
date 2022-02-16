package com.urban.norbert.androidflickrtest.ui.main

import com.urban.norbert.androidflickrtest.domain.ImageInteractor
import javax.inject.Inject

class MainScreenPresenter @Inject constructor(
    private val imageInteractor: ImageInteractor
) {

    suspend fun getImagesByTags(tags: String, pageNum: Int) =
        imageInteractor.getImagesByTags(tags = tags, pageNum = pageNum)
}
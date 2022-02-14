package com.urban.norbert.androidflickrtest.ui.main

import com.urban.norbert.androidflickrtest.domain.ImageInteractor
import javax.inject.Inject

class MainScreenPresenter @Inject constructor(
    private val imageInteractor: ImageInteractor
) {

    suspend fun getImageByName(imageName: String, pageNum: Int) =
        imageInteractor.getImageByName(imageName = imageName, pageNum = pageNum)
}
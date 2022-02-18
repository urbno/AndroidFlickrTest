package com.urban.norbert.androidflickrtest.ui.details

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import java.io.IOException
import javax.inject.Inject

class DetailsScreenViewModel @Inject constructor(
    private val detailsScreenPresenter: DetailsScreenPresenter
) :
    RainbowCakeViewModel<DetailsScreenViewState>(Initial) {

    // from DB
    fun getImageDetailsById(imageId: String) = execute {
        viewState = Loading
        viewState = try {
            val result = detailsScreenPresenter.getImageById(imageId = imageId)
            DetailsReady(result)
        } catch (e: IOException) {
            DatabaseError
        }
    }
}
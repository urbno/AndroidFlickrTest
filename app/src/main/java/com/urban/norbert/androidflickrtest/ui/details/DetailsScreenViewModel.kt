package com.urban.norbert.androidflickrtest.ui.details

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class DetailsScreenViewModel @Inject constructor(
    private val detailsScreenPresenter: DetailsScreenPresenter
) :
    RainbowCakeViewModel<DetailsScreenViewState>(Initial) {

    fun getImageDetailsById(imageId: String) {
        viewState = Loading
        executeNonBlocking {
            detailsScreenPresenter.getImageById(imageId = imageId).collect {
                viewState = DetailsReady(it)
            }
        }
    }

}
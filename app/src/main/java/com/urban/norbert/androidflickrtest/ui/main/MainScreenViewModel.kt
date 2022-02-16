package com.urban.norbert.androidflickrtest.ui.main

import androidx.lifecycle.viewModelScope
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val mainScreenPresenter: MainScreenPresenter
) : RainbowCakeViewModel<MainScreenViewState>(Initial) {

    private val TAG = MainScreenViewModel::class.java.simpleName

    // region network

    fun searchImageByTags(tags: String, pageNum: Int) = execute {
        viewState = Loading
        viewState = try {
            val result = mainScreenPresenter.getImagesByTags(tags = tags, pageNum = pageNum)
            DataReady(result)
        } catch (e: Exception) {
            NetworkError
        }
    }

    // endregion network

}
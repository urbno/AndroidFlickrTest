package com.urban.norbert.androidflickrtest.ui.main

import android.util.Log
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import timber.log.Timber
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val mainScreenPresenter: MainScreenPresenter
) : RainbowCakeViewModel<MainScreenViewState>(Initial) {

    private val TAG = MainScreenViewModel::class.java.simpleName

    // region network

    fun searchImageByName(imageName: String, pageNum: Int) = execute {
        viewState = Loading
        viewState = try {
            val result = mainScreenPresenter.getImageByName(imageName = imageName, pageNum = pageNum)
            DataReady(result)
        } catch (e: Exception) {
            NetworkError
        }
    }

    // endregion network

}
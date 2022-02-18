package com.urban.norbert.androidflickrtest.ui.main

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import kotlinx.coroutines.flow.collect
import java.lang.Exception
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val mainScreenPresenter: MainScreenPresenter
) : RainbowCakeViewModel<MainScreenViewState>(Initial) {

    private val TAG = MainScreenViewModel::class.java.simpleName

    fun searchImagesByTags(query: String) {
        viewState = Loading
        try {
            executeNonBlocking {
                mainScreenPresenter.getImagesByTags(tags = query).cachedIn(viewModelScope).collect {
                    viewState = DataReady(it)
                }
            }
        } catch (e: Exception) {
            NetworkError
        }
    }

    fun deleteAllImages() = executeNonBlocking {
        mainScreenPresenter.deleteAllImages()
    }
}
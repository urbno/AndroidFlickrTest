package com.urban.norbert.androidflickrtest.ui.main

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import co.zsmb.rainbowcake.base.QueuedOneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.urban.norbert.androidflickrtest.model.Photos
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val mainScreenPresenter: MainScreenPresenter
) : RainbowCakeViewModel<MainScreenViewState>(Initial) {

    private val TAG = MainScreenViewModel::class.java.simpleName

    fun searchImagesByTags(query: String) = mainScreenPresenter.getImagesByTags(query).cachedIn(viewModelScope)

    // endregion network

}
package com.urban.norbert.androidflickrtest.ui.main

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import co.zsmb.rainbowcake.base.QueuedOneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.urban.norbert.androidflickrtest.data.QueryEntity
import com.urban.norbert.androidflickrtest.network.NetworkConfig
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val mainScreenPresenter: MainScreenPresenter
) : RainbowCakeViewModel<MainScreenViewState>(Initial) {

    private val TAG = MainScreenViewModel::class.java.simpleName

    class QueryMessage(val message: String) : QueuedOneShotEvent

    fun searchImagesByTags(query: String) {
        viewState = Loading
        try {
            executeNonBlocking {
                mainScreenPresenter.getImagesByTags(tags = query).cachedIn(viewModelScope).collect {
                    viewState = DataReady(result = it)
                }
            }
        } catch (e: Exception) {
            NetworkError
        }
    }

    fun deleteDatabases() = executeNonBlocking {
        mainScreenPresenter.deleteAllImages()
        mainScreenPresenter.deleteQuery()
    }

    fun getLatestQuery() = executeNonBlocking {
        mainScreenPresenter.getQuery().collectLatest {
            if (it.query.isNotEmpty()) {
                postQueuedEvent(QueryMessage(message = it.query))
            } else {
                postQueuedEvent(QueryMessage(message = NetworkConfig.FIRST_QUERY_TAG))
            }
        }
    }

    fun insertQuery(query: String) = executeNonBlocking {
        mainScreenPresenter.insertQuery(QueryEntity(queryDBId = null, query = query))
    }
}
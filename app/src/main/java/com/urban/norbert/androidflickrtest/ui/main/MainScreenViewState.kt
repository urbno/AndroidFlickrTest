package com.urban.norbert.androidflickrtest.ui.main

import androidx.paging.PagingData
import com.urban.norbert.androidflickrtest.model.Photo

sealed class MainScreenViewState

object Initial : MainScreenViewState()

object Loading : MainScreenViewState()

data class DataReady(val result: PagingData<Photo>) : MainScreenViewState()

object NetworkError : MainScreenViewState()

object DatabaseError : MainScreenViewState()
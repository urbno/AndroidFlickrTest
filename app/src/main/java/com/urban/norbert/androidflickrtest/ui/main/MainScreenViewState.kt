package com.urban.norbert.androidflickrtest.ui.main

import com.urban.norbert.androidflickrtest.model.ImagesData

sealed class MainScreenViewState

object Initial : MainScreenViewState()

object Loading : MainScreenViewState()

data class DataReady(val result: ImagesData) : MainScreenViewState()

object NetworkError : MainScreenViewState()

object DatabaseError : MainScreenViewState()
package com.urban.norbert.androidflickrtest.ui.main

sealed class MainScreenViewState

object Initial : MainScreenViewState()

object Loading : MainScreenViewState()
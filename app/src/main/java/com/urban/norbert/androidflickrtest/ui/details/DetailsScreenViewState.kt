package com.urban.norbert.androidflickrtest.ui.details

sealed class DetailsScreenViewState

object Initial: DetailsScreenViewState()

object Loading : DetailsScreenViewState()
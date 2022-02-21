package com.urban.norbert.androidflickrtest.ui.details

import com.urban.norbert.androidflickrtest.data.ImageEntity

sealed class DetailsScreenViewState

object Initial : DetailsScreenViewState()

object Loading : DetailsScreenViewState()

data class DetailsReady(val result: ImageEntity) : DetailsScreenViewState()

object DatabaseError : DetailsScreenViewState()
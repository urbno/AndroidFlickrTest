package com.urban.norbert.androidflickrtest.ui.main

import com.urban.norbert.androidflickrtest.data.QueryEntity
import com.urban.norbert.androidflickrtest.domain.ImageInteractor
import javax.inject.Inject

class MainScreenPresenter @Inject constructor(
    private val imageInteractor: ImageInteractor
) {

    fun getImagesByTags(tags: String) =
        imageInteractor.getImagesByTags(tags = tags)

    suspend fun getSavedImages() =
        imageInteractor.getSavedImages()

    suspend fun deleteAllImages() =
        imageInteractor.deleteAllImages()

    suspend fun deleteQuery() =
        imageInteractor.deleteQuery()

    fun getQuery() =
        imageInteractor.getQuery()

    suspend fun isQueryAvailable() =
        imageInteractor.isQueryAvailable()

    suspend fun insertQuery(query: QueryEntity) =
        imageInteractor.insertQuery(query)
}
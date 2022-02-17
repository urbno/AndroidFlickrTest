package com.urban.norbert.androidflickrtest.ui.details

import android.graphics.Color
import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import com.example.awesomedialog.*
import com.urban.norbert.androidflickrtest.R
import com.urban.norbert.androidflickrtest.data.ImageEntity
import timber.log.Timber

class DetailsScreenFragment :
    RainbowCakeFragment<DetailsScreenViewState, DetailsScreenViewModel>() {

    private val TAG = DetailsScreenFragment::class.java.simpleName
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_details

    companion object {
        const val IMAGE_ID = "imageID"
    }

    private lateinit var imageId: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageId = requireArguments().getString(IMAGE_ID).toString()
        //viewModel.getImageDetailsById(imageId)
    }

    override fun render(viewState: DetailsScreenViewState) {
        when (viewState) {
            Initial -> {}
            Loading -> {

            }
            is DetailsReady -> {
                val detailResult = viewState.result
                Timber.d("$TAG - imageId: ${detailResult.imageId}")
                initDetailView(detailResult)
            }
            DatabaseError -> {
                //showDatabaseAlertDialog()
            }
        }.exhaustive
    }

    private fun initDetailView(image: ImageEntity) {

    }

    private fun showDatabaseAlertDialog() {
        AwesomeDialog.build(requireActivity())
            .title("Database Error", titleColor = Color.BLACK)
            .body("Something went wrong during database request", color = Color.BLACK)
            .icon(R.drawable.ic_error_symbol)
            .onPositive("Refresh") {
                Timber.d("$TAG network error on positive")
                // TODO Refresh
            }
    }
}
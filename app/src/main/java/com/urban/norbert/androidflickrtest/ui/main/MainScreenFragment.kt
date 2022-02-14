package com.urban.norbert.androidflickrtest.ui.main

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.view.isVisible
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.urban.norbert.androidflickrtest.R
import kotlinx.android.synthetic.main.fragment_main.*
import timber.log.Timber

class MainScreenFragment : RainbowCakeFragment<MainScreenViewState, MainScreenViewModel>() {

    private var TAG = MainScreenFragment::class.java.simpleName

    override fun provideViewModel() = getViewModelFromFactory()

    override fun getViewResource() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image_name_search_field.setOnEditorActionListener { _, keyCode, _ ->
            if (keyCode == EditorInfo.IME_ACTION_DONE) {
                val imageNameToSearch = image_name_search_field.text.toString()
                if (imageNameToSearch.isNotEmpty()) {
                    viewModel.searchImageByName(imageNameToSearch, 1)
                    image_name_search_field.text?.clear()
                    return@setOnEditorActionListener true
                }
            }
            false
        }
    }

    override fun render(viewState: MainScreenViewState) {
        when (viewState) {
            Initial -> {

            }
            Loading -> {
                progress_bar.isVisible = true
                recycler_view.isVisible = false
            }
            is DataReady -> {
                progress_bar.isVisible = false
                recycler_view.isVisible = true
                Timber.d("$TAG network result: ${viewState.result}")
            }
            DatabaseError -> {

            }
            NetworkError -> {

            }
        }
    }

}
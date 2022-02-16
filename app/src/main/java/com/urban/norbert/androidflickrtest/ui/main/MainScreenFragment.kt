package com.urban.norbert.androidflickrtest.ui.main

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.urban.norbert.androidflickrtest.R
import com.urban.norbert.androidflickrtest.model.ImagesData
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.launch
import timber.log.Timber
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle
import java.util.regex.Pattern

class MainScreenFragment : RainbowCakeFragment<MainScreenViewState, MainScreenViewModel>() {

    private var TAG = MainScreenFragment::class.java.simpleName

    override fun provideViewModel() = getViewModelFromFactory()

    override fun getViewResource() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //viewModel.searchImageByTags("Dog", 1)

        image_name_search_field.setOnEditorActionListener { _, keyCode, _ ->
            if (keyCode == EditorInfo.IME_ACTION_DONE) {
                val imageNameToSearch = image_name_search_field.text.toString().trim()
                if (checkInputIsValid(imageNameToSearch)) {
                    viewModel.searchImageByTags(imageNameToSearch, 1)
                    image_name_search_field.text?.clear()
                    return@setOnEditorActionListener true
                } else {
                    showInputWarningMessage()
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

    private fun checkInputIsValid(input: String) =
        input.isNotEmpty() && Pattern.compile("^[a-zA-Z]+(,[a-zA-Z]+)*$").matcher(input).find()


    private fun showInputWarningMessage() {
        MotionToast.createToast(
            requireActivity(), title = resources.getString(R.string.warning_title),
            message = resources.getString(R.string.warning_message),
            style = MotionToastStyle.WARNING,
            position = MotionToast.GRAVITY_BOTTOM,
            duration = MotionToast.LONG_DURATION,
            font = ResourcesCompat.getFont(requireContext(), R.font.helvetica_regular)
        )
    }

    private fun collectImageData() {
        viewLifecycleOwner.lifecycleScope.launch {

        }
    }

}
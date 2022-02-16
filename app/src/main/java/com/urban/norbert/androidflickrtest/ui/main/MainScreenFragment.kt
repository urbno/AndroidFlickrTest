package com.urban.norbert.androidflickrtest.ui.main

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.navigator
import com.urban.norbert.androidflickrtest.R
import com.urban.norbert.androidflickrtest.model.Photo
import com.urban.norbert.androidflickrtest.ui.details.DetailsScreenFragment
import com.urban.norbert.androidflickrtest.ui.main.adapters.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle
import java.util.regex.Pattern

class MainScreenFragment : RainbowCakeFragment<MainScreenViewState, MainScreenViewModel>() {

    private var TAG = MainScreenFragment::class.java.simpleName

    private var imageNameToSearch = "Dog"
    private lateinit var imagesAdapter: RecyclerViewAdapter

    override fun provideViewModel() = getViewModelFromFactory()

    override fun getViewResource() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imagesAdapter = RecyclerViewAdapter(::onPhotoItemClicked)
        recycler_view.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = imagesAdapter
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.searchImagesByTags(imageNameToSearch).collect { data ->
                imagesAdapter.submitData(viewLifecycleOwner.lifecycle, data)
            }
        }

        /*viewModel.photos.observe(viewLifecycleOwner) { data ->
            imagesAdapter.submitData(viewLifecycleOwner.lifecycle, data)
        }*/

        image_name_search_field.setOnEditorActionListener { _, keyCode, _ ->
            if (keyCode == EditorInfo.IME_ACTION_DONE) {
                imageNameToSearch = image_name_search_field.text.toString().trim()
                if (checkInputIsValid(imageNameToSearch)) {
                    viewLifecycleOwner.lifecycleScope.launch {
                        viewModel.searchImagesByTags(imageNameToSearch).collect { data ->
                            imagesAdapter.submitData(viewLifecycleOwner.lifecycle, data)
                        }
                    }
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

    private fun onPhotoItemClicked(photo: Photo) =
        navigator?.add(DetailsScreenFragment().applyArgs {
            putString("Key", "Value")
        })

}
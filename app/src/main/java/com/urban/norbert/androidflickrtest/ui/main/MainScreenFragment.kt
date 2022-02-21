package com.urban.norbert.androidflickrtest.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.navigator
import com.example.awesomedialog.*
import com.urban.norbert.androidflickrtest.R
import com.urban.norbert.androidflickrtest.model.Photo
import com.urban.norbert.androidflickrtest.ui.details.DetailsScreenFragment
import com.urban.norbert.androidflickrtest.ui.main.adapters.PhotoLoadStateAdapter
import com.urban.norbert.androidflickrtest.ui.main.adapters.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import timber.log.Timber
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle
import java.util.regex.Pattern

class MainScreenFragment : RainbowCakeFragment<MainScreenViewState, MainScreenViewModel>() {

    private var TAG = MainScreenFragment::class.java.simpleName

    private lateinit var imageNameToSearch: String
    private lateinit var imagesAdapter: RecyclerViewAdapter
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        viewModel.getLatestQuery()
        addSearchListener()
    }

    override fun render(viewState: MainScreenViewState) {
        when (viewState) {
            Initial -> {}
            Loading -> {
                progress_bar.isVisible = true
                recycler_view.isVisible = false
            }
            is DataReady -> {
                progress_bar.isVisible = false
                recycler_view.isVisible = true
                Timber.d("$TAG network result: ${viewState.result}")
                imagesAdapter.submitData(viewLifecycleOwner.lifecycle, viewState.result)
            }
            DatabaseError -> {
                showDatabaseAlertDialog()
            }
            NetworkError -> {
                showNetworkAlertDialog()
            }
        }.exhaustive
    }

    override fun onEvent(event: OneShotEvent) {
        super.onEvent(event)
        when (event) {
            is MainScreenViewModel.QueryMessage -> {
                viewModel.searchImagesByTags(event.message)
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

    private fun initRecyclerView() {
        imagesAdapter = RecyclerViewAdapter(::onPhotoItemClicked)
        recycler_view.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = imagesAdapter.withLoadStateHeaderAndFooter(
                header = PhotoLoadStateAdapter { imagesAdapter.retry() },
                footer = PhotoLoadStateAdapter { imagesAdapter.retry() }
            )
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun addSearchListener() {
        image_name_search_field.setOnEditorActionListener { _, keyCode, _ ->
            if (keyCode == EditorInfo.IME_ACTION_DONE) {
                imageNameToSearch = image_name_search_field.text.toString().trim()
                if (checkInputIsValid(imageNameToSearch)) {
                    viewModel.deleteDatabases()
                    viewModel.insertQuery(imageNameToSearch)
                    viewModel.searchImagesByTags(imageNameToSearch)
                    image_name_search_field.text?.clear()
                    return@setOnEditorActionListener true
                } else {
                    showInputWarningMessage()
                }
            }
            false
        }
    }

    private fun onPhotoItemClicked(photo: Photo) =
        navigator?.add(DetailsScreenFragment().applyArgs {
            putString(DetailsScreenFragment.IMAGE_ID, photo.id)
        })

    private fun showNetworkAlertDialog() {
        AwesomeDialog.build(requireActivity())
            .title("Network Error", titleColor = Color.BLACK)
            .body("Something went wrong during network request", color = Color.BLACK)
            .icon(R.drawable.ic_error_symbol)
            .onPositive("Refresh") {
                Timber.d("$TAG network error on positive")
            }
    }

    private fun showDatabaseAlertDialog() {
        AwesomeDialog.build(requireActivity())
            .title("Database Error", titleColor = Color.BLACK)
            .body("Something went wrong during database request", color = Color.BLACK)
            .icon(R.drawable.ic_error_symbol)
            .onPositive("Refresh") {
                Timber.d("$TAG network error on positive")
            }
    }
}
package com.urban.norbert.androidflickrtest.ui.details

import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.koin.getViewModelFromFactory
import com.urban.norbert.androidflickrtest.R

class DetailsScreenFragment : RainbowCakeFragment<DetailsScreenViewState, DetailsScreenViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()

    override fun getViewResource() = R.layout.fragment_details

    override fun render(viewState: DetailsScreenViewState) {
    }
}
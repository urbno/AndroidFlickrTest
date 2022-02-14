package com.urban.norbert.androidflickrtest.ui.main

import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.urban.norbert.androidflickrtest.R

class MainScreenFragment : RainbowCakeFragment<MainScreenViewState, MainScreenViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()

    override fun getViewResource() = R.layout.fragment_main

    override fun render(viewState: MainScreenViewState) {
    }

}
package com.urban.norbert.androidflickrtest.di

import androidx.lifecycle.ViewModel
import co.zsmb.rainbowcake.dagger.ViewModelKey
import com.urban.norbert.androidflickrtest.ui.details.DetailsScreenViewModel
import com.urban.norbert.androidflickrtest.ui.main.MainScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    abstract fun bindMainScreenViewModel(mainScreenViewModel: MainScreenViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsScreenViewModel::class)
    abstract fun bindDetailsScreenViewModel(detailsScreenViewModel: DetailsScreenViewModel): ViewModel
}
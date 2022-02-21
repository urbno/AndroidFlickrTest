package com.urban.norbert.androidflickrtest.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import com.urban.norbert.androidflickrtest.data.DiskModule
import com.urban.norbert.androidflickrtest.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RainbowCakeModule::class,
        ViewModelModule::class,
        ApplicationModule::class,
        NetworkModule::class,
        DiskModule::class
    ]
)
interface AppComponent : RainbowCakeComponent
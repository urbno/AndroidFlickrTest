package com.urban.norbert.androidflickrtest

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import com.urban.norbert.androidflickrtest.ui.main.MainScreenFragment

class MainActivity : SimpleNavActivity() {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            navigator.add(MainScreenFragment())
        }
    }
}
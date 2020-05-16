package com.okawa.sample.googlemaps.data.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    @get:LayoutRes
    protected abstract val layoutToInflate: Int

    protected open fun setupViewModel() { }

    protected open fun setupViews() { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutToInflate)
        setupViewModel()
        setupViews()
    }

}
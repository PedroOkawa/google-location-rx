package com.okawa.sample.googlemaps.data.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @get:LayoutRes
    protected abstract val layoutToInflate: Int

    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory = viewModelFactory

    protected open fun setupViewModel() { }

    protected open fun setupViews() { }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutToInflate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupViews()
    }

    protected fun navigateTo(@IdRes action: Int, bundle: Bundle? = null, navOptions: NavOptions? = null) {
        NavHostFragment.findNavController(this).navigate(action, bundle, navOptions)
    }

    protected fun navigateTo(navDirections: NavDirections) {
        NavHostFragment.findNavController(this).navigate(navDirections)
    }

    fun navigateUp() {
        findNavController().navigateUp()
    }

}
package com.okawa.sample.googlemaps.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.okawa.sample.googlemaps.di.viewmodel.ViewModelFactory
import com.okawa.sample.googlemaps.di.viewmodel.ViewModelKey
import com.okawa.sample.googlemaps.ui.home.HomeViewModel
import com.okawa.sample.googlemaps.ui.tracker.TrackerViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun homeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TrackerViewModel::class)
    internal abstract fun trackerViewModel(viewModel: TrackerViewModel): ViewModel

}
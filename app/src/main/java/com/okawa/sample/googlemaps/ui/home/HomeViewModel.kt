package com.okawa.sample.googlemaps.ui.home

import androidx.lifecycle.LiveData
import com.okawa.sample.googlemaps.data.viewmodel.BaseViewModel
import com.okawa.sample.googlemaps.data.livedata.SingleLiveEvent
import com.okawa.sample.googlemaps.data.schedulers.BaseSchedulerProvider
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    baseSchedulerProvider: BaseSchedulerProvider
) : BaseViewModel(baseSchedulerProvider) {

    private val _navigation =
        SingleLiveEvent<Navigation>()
    val navigation: LiveData<Navigation> = _navigation

    fun onTrackClicked() {
        _navigation.postValue(Navigation.Tracker)
    }

    sealed class Navigation {
        object Tracker : Navigation()
    }

}
package com.okawa.sample.googlemaps.ui.tracker

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.okawa.sample.googlemaps.data.viewmodel.BaseViewModel
import com.okawa.sample.googlemaps.data.livedata.SingleLiveEvent
import com.okawa.sample.googlemaps.data.schedulers.BaseSchedulerProvider
import com.okawa.sample.googlemaps.domain.usecase.GetLocationUseCase
import com.okawa.sample.googlemaps.model.LocationModel
import com.okawa.sample.googlemaps.model.mapToPresentation
import javax.inject.Inject

class TrackerViewModel @Inject constructor(
    private val getLocationUseCase: GetLocationUseCase,
    baseSchedulerProvider: BaseSchedulerProvider
) : BaseViewModel(baseSchedulerProvider) {

    private val _locationModel = MutableLiveData<LocationModel>()
    val locationModel: LiveData<LocationModel> = _locationModel

    private val _navigation =
        SingleLiveEvent<Navigation>()
    val navigation: LiveData<Navigation> = _navigation

    fun onLocationPermissionGranted() {
        getLocationUseCase
            .build()
            .map { it.mapToPresentation() }
            .baseSubscribe(
                onSuccess = ::onGetLocationSuccess,
                onError = ::onGetLocationError
            )
    }

    fun onLocationPermissionDenied() {
        _navigation.postValue(Navigation.Finish)
    }

    private fun onGetLocationSuccess(locationModel: LocationModel) {
        _locationModel.postValue(locationModel)
    }

    private fun onGetLocationError(throwable: Throwable) {
        Log.e(TrackerViewModel::class.simpleName, throwable.message.orEmpty())
    }

    sealed class Navigation {
        object Finish : Navigation()
    }

}
package com.okawa.sample.googlemaps.ui.tracker

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.okawa.sample.googlemaps.data.viewmodel.BaseViewModel
import com.okawa.sample.googlemaps.data.livedata.SingleLiveEvent
import com.okawa.sample.googlemaps.data.schedulers.BaseSchedulerProvider
import com.okawa.sample.googlemaps.domain.usecase.GetLocationUseCase
import com.okawa.sample.googlemaps.model.APPROXIMATE_ZOOM_BUILDINGS
import com.okawa.sample.googlemaps.model.APPROXIMATE_ZOOM_STREETS
import com.okawa.sample.googlemaps.model.LocationModel
import com.okawa.sample.googlemaps.model.mapToPresentation
import com.okawa.sample.googlemaps.utils.PermissionsManager
import javax.inject.Inject

class TrackerViewModel @Inject constructor(
    private val getLocationUseCase: GetLocationUseCase,
    baseSchedulerProvider: BaseSchedulerProvider
) : BaseViewModel(baseSchedulerProvider) {

    private val _locationModel = MutableLiveData<LocationModel>()
    val locationModel: LiveData<LocationModel> = _locationModel

    private val _navigation = SingleLiveEvent<Navigation>()
    val navigation: LiveData<Navigation> = _navigation

    fun onRequestPermissionResult(requestCode: Int, grantResults: IntArray) {
        if (requestCode == PermissionsManager.LOCATION_PERMISSION_REQUEST_CODE && grantResults.isNotEmpty()) {
            when (grantResults.first()) {
                PermissionsManager.PERMISSION_GRANTED -> onLocationPermissionGranted()
                PermissionsManager.PERMISSION_DENIED -> onLocationPermissionDenied()
            }
        }
    }

    fun onLocationPermissionGranted() {
        getLocationUseCase
            .build()
            .map { it.mapToPresentation(APPROXIMATE_ZOOM_BUILDINGS) }
            .baseSubscribe(
                onSuccess = ::onGetLocationSuccess,
                onError = ::onGetLocationError
            )
    }

    private fun onLocationPermissionDenied() {
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
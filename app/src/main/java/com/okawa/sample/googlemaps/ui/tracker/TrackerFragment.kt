package com.okawa.sample.googlemaps.ui.tracker

import android.content.pm.PackageManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.okawa.sample.googlemaps.R
import com.okawa.sample.googlemaps.data.ui.BaseFragment
import com.okawa.sample.googlemaps.model.LocationModel
import com.okawa.sample.googlemaps.ui.tracker.TrackerViewModel.*
import com.okawa.sample.googlemaps.ui.tracker.TrackerViewModel.Navigation.*
import com.okawa.sample.googlemaps.utils.PermissionsManager
import javax.inject.Inject

class TrackerFragment : BaseFragment(), OnMapReadyCallback {

    @Inject
    lateinit var permissionsManager: PermissionsManager

    private var googleMap: GoogleMap? = null

    private val viewModel: TrackerViewModel by viewModels()

    override val layoutToInflate: Int
        get() = R.layout.fragment_tracker

    override fun setupViews() {
        (childFragmentManager.findFragmentById(R.id.fg_tracker_map) as? SupportMapFragment)?.apply {
            getMapAsync(this@TrackerFragment)
        }
    }

    override fun setupViewModel() {
        with (viewModel) {
            locationModel.observe(viewLifecycleOwner, Observer(::onLocationModel))
            navigation.observe(viewLifecycleOwner, Observer(::onNavigation))
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PermissionsManager.LOCATION_PERMISSION_REQUEST_CODE && grantResults.isNotEmpty()) {
            when (grantResults.first()) {
                PackageManager.PERMISSION_GRANTED -> viewModel.onLocationPermissionGranted()
                PackageManager.PERMISSION_DENIED -> viewModel.onLocationPermissionDenied()
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        this.googleMap = googleMap
        requestLocationPermission()
    }

    private fun requestLocationPermission() {
        if (permissionsManager.isLocationPermissionGranted(requireContext())) {
            viewModel.onLocationPermissionGranted()
        } else {
            permissionsManager.requestLocationPermission(this)
        }
    }

    private fun onLocationModel(locationModel: LocationModel) {
        googleMap?.apply {
            clear()
            addMarker(MarkerOptions().position(LatLng(locationModel.latitude, locationModel.longitude)))
        }
    }

    private fun onNavigation(navigation: Navigation?) {
        when (navigation) {
            Finish -> navigateUp()
        }
    }

}
package com.okawa.sample.googlemaps.ui.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.okawa.sample.googlemaps.R
import com.okawa.sample.googlemaps.data.ui.BaseFragment
import com.okawa.sample.googlemaps.common.throttleClick
import com.okawa.sample.googlemaps.ui.home.HomeViewModel.Navigation
import com.okawa.sample.googlemaps.ui.home.HomeViewModel.Navigation.Tracker
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModels()

    override val layoutToInflate: Int
        get() = R.layout.fragment_home

    override fun setupViewModel() {
        viewModel.navigation.observe(viewLifecycleOwner, Observer(::onNavigation))
    }

    override fun setupViews() {
        btn_home_track.throttleClick {
            viewModel.onTrackClicked()
        }
    }

    private fun onNavigation(navigation: Navigation?) {
        when (navigation) {
            Tracker -> onNavigateToTracker()
        }
    }

    private fun onNavigateToTracker() {
        val action = HomeFragmentDirections.homeToTracker()
        navigateTo(action)
    }
}
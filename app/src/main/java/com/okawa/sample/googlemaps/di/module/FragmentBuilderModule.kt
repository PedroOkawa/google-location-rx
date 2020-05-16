package com.okawa.sample.googlemaps.di.module

import com.okawa.sample.googlemaps.ui.home.HomeFragment
import com.okawa.sample.googlemaps.ui.tracker.TrackerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributesTrackerFragment(): TrackerFragment

}
package com.okawa.sample.googlemaps.data.di

import com.okawa.sample.googlemaps.data.schedulers.BaseSchedulerProvider
import com.okawa.sample.googlemaps.data.schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class SchedulerModule {

    @Provides
    fun providesSchedulerProvider(): BaseSchedulerProvider {
        return SchedulerProvider()
    }

}
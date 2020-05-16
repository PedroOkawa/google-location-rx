package com.okawa.sample.googlemaps.data.di

import com.okawa.sample.googlemaps.data.repository.LocationRepositoryImpl
import com.okawa.sample.googlemaps.data.source.GoogleLocationDataSource
import com.okawa.sample.googlemaps.domain.repository.LocationRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providesLocationRepository(googleLocationDataSource: GoogleLocationDataSource): LocationRepository {
        return LocationRepositoryImpl(googleLocationDataSource)
    }

}
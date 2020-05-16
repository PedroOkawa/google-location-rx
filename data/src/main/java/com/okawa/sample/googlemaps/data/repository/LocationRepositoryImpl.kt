package com.okawa.sample.googlemaps.data.repository

import com.okawa.sample.googlemaps.data.source.GoogleLocationDataSource
import com.okawa.sample.googlemaps.domain.model.LocationDomainModel
import com.okawa.sample.googlemaps.domain.repository.LocationRepository
import io.reactivex.Flowable
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val googleLocationDataSource: GoogleLocationDataSource
) : LocationRepository {

    override fun getLocation(): Flowable<LocationDomainModel> {
        return googleLocationDataSource
            .locationObservable
            .map { it.mapToDomain() }
    }

}
package com.okawa.sample.googlemaps.domain.usecase

import com.okawa.sample.googlemaps.domain.model.LocationDomainModel
import com.okawa.sample.googlemaps.domain.repository.LocationRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetLocationUseCase @Inject constructor(
    private val locationRepository: LocationRepository
) {

    fun build() : Flowable<LocationDomainModel> {
        return locationRepository.getLocation()
    }

}
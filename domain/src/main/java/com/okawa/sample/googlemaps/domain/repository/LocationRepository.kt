package com.okawa.sample.googlemaps.domain.repository

import com.okawa.sample.googlemaps.domain.model.LocationDomainModel
import io.reactivex.Flowable

interface LocationRepository {

    fun getLocation(): Flowable<LocationDomainModel>

}
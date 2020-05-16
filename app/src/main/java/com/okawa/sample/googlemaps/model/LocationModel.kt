package com.okawa.sample.googlemaps.model

import com.okawa.sample.googlemaps.domain.model.LocationDomainModel

data class LocationModel(
    val latitude: Double,
    val longitude: Double
)

fun LocationDomainModel.mapToPresentation(): LocationModel {
    return LocationModel(latitude, longitude)
}
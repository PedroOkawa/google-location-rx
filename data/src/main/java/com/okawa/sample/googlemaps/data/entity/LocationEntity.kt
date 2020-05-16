package com.okawa.sample.googlemaps.data.entity

import com.okawa.sample.googlemaps.domain.model.LocationDomainModel

data class LocationEntity(
    val latitude: Double,
    val longitude: Double
) {
    fun mapToDomain() : LocationDomainModel {
        return LocationDomainModel(
            latitude,
            longitude
        )
    }
}
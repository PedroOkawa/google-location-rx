package com.okawa.sample.googlemaps.model

import com.okawa.sample.googlemaps.domain.model.LocationDomainModel

const val APPROXIMATE_ZOOM_WORLD = 1f
const val APPROXIMATE_ZOOM_CONTINENT = 5f
const val APPROXIMATE_ZOOM_CITY = 10f
const val APPROXIMATE_ZOOM_STREETS = 15f
const val APPROXIMATE_ZOOM_BUILDINGS = 20f

data class LocationModel(
    val latitude: Double,
    val longitude: Double,
    val zoom: Float
)

fun LocationDomainModel.mapToPresentation(zoom: Float): LocationModel {
    return LocationModel(latitude, longitude, zoom)
}
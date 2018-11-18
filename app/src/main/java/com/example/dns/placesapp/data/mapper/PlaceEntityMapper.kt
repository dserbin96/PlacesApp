package com.example.dns.placesapp.data.mapper

import com.example.dns.placesapp.data.model.PlaceDTO
import com.example.dns.placesapp.domain.global.entity.PlaceEntity
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class PlaceEntityMapper @Inject constructor(private val categoryMapper: CategoryEntitityMapper) {

    fun mapToPlaceEntity(placeDTO: PlaceDTO?): PlaceEntity? {
        return placeDTO?.let { place ->
            PlaceEntity(place.id,
                    place.name,
                    place.referralId,
                    LatLng(place.location.lat, place.location.lng),
                    place.location.address,
                    place.location.crossStreet,
                    place.location.city,
                    place.location.country,
                    place.categories.map { categoryMapper.mapToCategoryEntity(it) })

        }
    }

}
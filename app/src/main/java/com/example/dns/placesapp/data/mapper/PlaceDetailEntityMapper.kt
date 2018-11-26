package com.example.dns.placesapp.data.mapper

import com.example.dns.placesapp.data.model.PlaceDetailDTO
import com.example.dns.placesapp.domain.global.entity.PlaceDetailEntity
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class PlaceDetailEntityMapper @Inject constructor(private val mapperCategory: CategoryEntitityMapper,
                                                  private val mapperPhoto: PhotoStringMapper) {

    fun mapToPlaceEntity(placeDTO: PlaceDetailDTO?): PlaceDetailEntity? {
        return placeDTO?.let { place ->
            PlaceDetailEntity(
                    place.id,
                    place.name,
                    place.location?.let { LatLng(it.lat, it.lng) },
                    place.location?.address,
                    place.categories?.map { mapperCategory.mapToCategoryEntity(it) },
                    place.rating,
                    place.photos?.items?.map { mapperPhoto.mapToString(it) },
                    mapperPhoto.mapToString(place.bestPhoto),
                    place.timeWork?.isOpen,
                    place.timeWork?.timeframes?.get(0)?.open?.get(0)?.renderedTime,
                    place.description)
        }
    }

}
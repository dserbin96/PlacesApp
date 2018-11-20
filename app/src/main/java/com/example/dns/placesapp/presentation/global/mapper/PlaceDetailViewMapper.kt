package com.example.dns.placesapp.presentation.global.mapper

import com.example.dns.placesapp.domain.global.entity.PlaceDetailEntity
import com.example.dns.placesapp.presentation.global.model.PlaceDetailViewModel
import javax.inject.Inject

class PlaceDetailViewMapper @Inject constructor() {

    fun mapToPlaceDetailView(place: PlaceDetailEntity?): PlaceDetailViewModel? {
        return PlaceDetailViewModel(place?.id.orEmpty(),
                place?.name.orEmpty(),
                place?.latLng,
                place?.address,
                place?.rating,
                place?.photosPath,
                place?.timeWorks,
                place?.basePhoto)
    }

}
package com.example.dns.placesapp.presentation.global.mapper

import com.example.dns.placesapp.domain.global.entity.PlaceEntity
import com.example.dns.placesapp.presentation.global.model.PlaceViewModel
import javax.inject.Inject

class PlaceViewMapper @Inject constructor() {

    fun mapToPlaceView(entity: PlaceEntity?): PlaceViewModel {
        return PlaceViewModel(entity?.id.orEmpty(),
                null,
                entity?.name,
                entity?.address,
                null)
    }

}
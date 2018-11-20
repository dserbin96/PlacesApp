package com.example.dns.placesapp.presentation.global.mapper

import com.example.dns.placesapp.domain.global.entity.PlaceEntity
import com.example.dns.placesapp.presentation.global.model.PlaceViewModel
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class PlaceViewMapper @Inject constructor() {

    fun mapToPlaceView(entity: PlaceEntity?): PlaceViewModel {
        return PlaceViewModel(entity?.id.orEmpty(),
                entity?.name,
                entity?.referraIld,
                entity?.latLng ?: LatLng(0.0, 0.0),
                entity?.address,
                entity?.street,
                entity?.city,
                entity?.country,
                entity?.categories)
    }

}
package com.example.dns.placesapp.domain.global.repositories

import com.example.dns.placesapp.domain.global.entity.PlaceDetailEntity
import com.example.dns.placesapp.domain.global.entity.PlaceEntity
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Single

interface PlaceRepository {
    fun searchPlace(latLng: LatLng): Single<List<PlaceEntity?>>
    fun getPlaceDetatil(id: String): Single<PlaceDetailEntity?>
}
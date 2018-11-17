package com.example.dns.placesapp.domain.global.repositories

import com.google.android.gms.maps.model.LatLng
import io.reactivex.Completable

interface SearchRepository {
    fun searchPlace(latLng: LatLng) : Completable
}
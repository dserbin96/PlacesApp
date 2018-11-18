package com.example.dns.placesapp.data.reposiories

import com.example.dns.placesapp.data.mapper.PlaceEntityMapper
import com.example.dns.placesapp.data.network.FoursquareApi
import com.example.dns.placesapp.domain.global.entity.PlaceEntity
import com.example.dns.placesapp.domain.global.repositories.SearchRepository
import com.example.dns.placesapp.presentation.ui.global.expansion.toStringWeb
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Single
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val api: FoursquareApi,
                                               private val map: PlaceEntityMapper) : SearchRepository {
    override fun searchPlace(latLng: LatLng): Single<List<PlaceEntity?>> {
        return api.searchPlace(latLng.toStringWeb())
                .map { places -> places.response?.map { map.mapToPlaceEntity(it) } }
    }
}
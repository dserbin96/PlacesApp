package com.example.dns.placesapp.data.reposiories

import com.example.dns.placesapp.data.mapper.PhotoStringMapper
import com.example.dns.placesapp.data.mapper.PlaceDetailEntityMapper
import com.example.dns.placesapp.data.mapper.PlaceEntityMapper
import com.example.dns.placesapp.data.network.FoursquareApi
import com.example.dns.placesapp.domain.global.entity.PlaceDetailEntity
import com.example.dns.placesapp.domain.global.entity.PlaceEntity
import com.example.dns.placesapp.domain.global.repositories.PlaceRepository
import com.example.dns.placesapp.presentation.ui.global.expansion.toStringWeb
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Single
import javax.inject.Inject

class PlaceRepositoryImpl @Inject constructor(private val api: FoursquareApi,
                                              private val placeMapper: PlaceEntityMapper,
                                              private val placeDetailEntityMapper: PlaceDetailEntityMapper,
                                              private val mapperPhoto: PhotoStringMapper) :
        PlaceRepository {

    override fun searchPlace(latLng: LatLng): Single<List<PlaceEntity?>> {
        return api.searchPlace(latLng.toStringWeb())
                .map { places -> places.response?.venues?.map { placeMapper.mapToPlaceEntity(it) } }
    }

    override fun getPlaceDetatil(id: String): Single<PlaceDetailEntity?> {
        return api.getPlaceDeatail(id)
                .map { placeDetailEntityMapper.mapToPlaceEntity(it.response?.venue) }
    }

    override fun getListPhoto(id: String): Single<List<String>> {
        return api.getPlacePhotos(id).map { place -> place.response?.photos?.items?.map { mapperPhoto.mapToString(it) } }
    }
}
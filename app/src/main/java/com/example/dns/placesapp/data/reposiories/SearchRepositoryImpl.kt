package com.example.dns.placesapp.data.reposiories

import com.example.dns.placesapp.data.network.FoursquareApi
import com.example.dns.placesapp.domain.global.repositories.SearchRepository
import com.example.dns.placesapp.presentation.ui.global.expansion.toStringWeb
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Completable
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val api: FoursquareApi) : SearchRepository {
    override fun searchPlace(latLng: LatLng): Completable {
        return api.searchPlace(latLng.toStringWeb())
    }
}
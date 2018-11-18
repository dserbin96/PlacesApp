package com.example.dns.placesapp.domain.feature.maps

import com.example.dns.placesapp.domain.global.base.SingleUseCase
import com.example.dns.placesapp.domain.global.entity.PlaceEntity
import com.example.dns.placesapp.domain.global.repositories.SearchRepository
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SearchUseCase @Inject constructor(override var disposable: CompositeDisposable,
                                        private val repository: SearchRepository) :
        SingleUseCase<SearchUseCase.Params,List<PlaceEntity?>>() {

    override fun build(parametrs: Params): Single<List<PlaceEntity?>> {
        return repository.searchPlace(parametrs.latLng)
    }

    data class Params(val latLng: LatLng)
}
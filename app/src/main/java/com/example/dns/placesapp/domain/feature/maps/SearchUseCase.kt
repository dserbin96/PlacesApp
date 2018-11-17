package com.example.dns.placesapp.domain.feature.maps

import com.example.dns.placesapp.domain.global.base.CompletableUseCase
import com.example.dns.placesapp.domain.global.repositories.SearchRepository
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SearchUseCase @Inject constructor(override var disposable: CompositeDisposable,
                                        private val repository: SearchRepository) :
        CompletableUseCase<SearchUseCase.Params>() {

    override fun build(params: Params): Completable {
        return repository.searchPlace(params.latLng)
    }

    data class Params(val latLng: LatLng)
}
package com.example.dns.placesapp.domain.feature.maps

import com.example.dns.placesapp.domain.global.base.SingleUseCase
import com.example.dns.placesapp.domain.global.entity.PlaceDetailEntity
import com.example.dns.placesapp.domain.global.repositories.PlaceRepository
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class GetPlaceUseCase @Inject constructor(override var disposable: CompositeDisposable,
                                          private val placeRepository: PlaceRepository) :
        SingleUseCase<GetPlaceUseCase.Params, PlaceDetailEntity?>() {
    override fun build(parametrs: Params): Single<PlaceDetailEntity?> {
        return placeRepository.getPlaceDetatil(parametrs.id)
    }

    data class Params(val id: String)
}
package com.example.dns.placesapp.presentation.mvp.feature.place_info

import android.location.Location
import com.arellomobile.mvp.InjectViewState
import com.example.dns.placesapp.presentation.global.model.PlaceDetailViewModel
import com.example.dns.placesapp.presentation.mvp.global.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class PlaceInfoPresenter @Inject constructor(private val model: PlaceDetailViewModel?,
                                             private val location: Location?)
    : BasePresenter<PlaceView>() {

    fun start() {
        if (model != null && location != null) viewState?.showInfo(model,location)

    }

}
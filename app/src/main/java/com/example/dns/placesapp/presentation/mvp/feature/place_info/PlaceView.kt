package com.example.dns.placesapp.presentation.mvp.feature.place_info

import android.location.Location
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.dns.placesapp.presentation.global.model.PlaceDetailViewModel
import com.example.dns.placesapp.presentation.mvp.global.base.BaseView
import com.example.dns.placesapp.presentation.mvp.global.error.CanShowError

@StateStrategyType(AddToEndSingleStrategy::class)
interface PlaceView : BaseView, CanShowError {

    fun showInfo(model: PlaceDetailViewModel, myLocation: Location)
    fun showPhoto(photos: List<String>)

}
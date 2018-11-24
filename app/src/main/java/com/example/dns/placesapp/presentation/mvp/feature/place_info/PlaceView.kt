package com.example.dns.placesapp.presentation.mvp.feature.place_info

import android.location.Location
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.dns.placesapp.presentation.global.model.PlaceDetailViewModel
import com.example.dns.placesapp.presentation.mvp.global.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface PlaceView : BaseView {

    fun showInfo(model: PlaceDetailViewModel, myLocation: Location)

}
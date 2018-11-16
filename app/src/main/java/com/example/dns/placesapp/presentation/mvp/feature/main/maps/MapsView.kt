package com.example.dns.placesapp.presentation.mvp.feature.main.maps

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.dns.placesapp.presentation.mvp.global.base.BaseView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

@StateStrategyType(AddToEndSingleStrategy::class)
interface MapsView : BaseView {
    fun mapZoom(latLng: LatLng, zoom: Float)
    fun addMarker(options: MarkerOptions)
}
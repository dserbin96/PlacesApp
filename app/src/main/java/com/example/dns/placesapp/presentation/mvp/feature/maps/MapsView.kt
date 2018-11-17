package com.example.dns.placesapp.presentation.mvp.feature.maps

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.dns.placesapp.presentation.mvp.global.base.BaseView
import com.example.dns.placesapp.presentation.mvp.global.error.CanShowError
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

@StateStrategyType(AddToEndSingleStrategy::class)
interface MapsView : BaseView, CanShowError {
    fun mapZoom(latLng: LatLng, zoom: Float)
    fun addMarker(options: MarkerOptions)
    fun currentPlaceMarker(latLng: LatLng)
    fun showLoading()
    fun hideLoading()
}
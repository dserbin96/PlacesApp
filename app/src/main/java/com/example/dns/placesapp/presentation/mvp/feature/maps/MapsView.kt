package com.example.dns.placesapp.presentation.mvp.feature.maps

import android.location.Location
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.dns.placesapp.presentation.global.model.PlaceDetailViewModel
import com.example.dns.placesapp.presentation.mvp.global.base.BaseView
import com.example.dns.placesapp.presentation.mvp.global.error.CanShowError
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

@StateStrategyType(AddToEndSingleStrategy::class)
interface MapsView : BaseView, CanShowError {
    fun mapZoom(latLng: LatLng, zoom: Float)
    fun mapZoom(latLng: LatLng)
    fun addMarker(options: MarkerOptions, id: String)
    fun currentPlaceMarker(latLng: LatLng)
    fun showLoading()
    fun hideLoading()
    fun showPlace(model: PlaceDetailViewModel, myLocation: Location)
}
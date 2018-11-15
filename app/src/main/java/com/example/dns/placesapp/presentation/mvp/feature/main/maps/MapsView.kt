package com.example.dns.placesapp.presentation.mvp.feature.main.maps

import com.example.dns.placesapp.presentation.mvp.global.base.BaseView
import com.google.android.gms.maps.model.LatLng

interface MapsView : BaseView{
    fun mapZoom(latLng: LatLng, zoom: Float)
}
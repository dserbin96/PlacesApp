package com.example.dns.placesapp.presentation.mvp.feature.main.maps

import android.annotation.SuppressLint
import android.location.Location
import com.example.dns.placesapp.presentation.mvp.global.base.BasePresenter
import com.example.dns.placesapp.presentation.ui.global.expansion.schedulers
import com.google.android.gms.maps.model.LatLng
import io.reactivex.functions.Consumer
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider

class MapsPresenter(private val locationProvider: ReactiveLocationProvider) :
        BasePresenter<MapsView>(), Consumer<Location> {

    companion object {
        private const val MAX_ZOOM = 20f
        private const val MIN_ZOOM = 0f
        private const val DEFAULT_ZOOM = 5f
    }

    private var currentZoom = DEFAULT_ZOOM
    private var currentLocation: Location? = null

    @SuppressLint("MissingPermission")
    fun start() {
        addToDisposable(locationProvider
                .lastKnownLocation
                .schedulers()
                .subscribe(this))
    }

    fun currentZoom() {
        currentZoom = DEFAULT_ZOOM
        currentLocation?.let {
            viewState.mapZoom(LatLng(it.latitude, it.longitude), currentZoom)
        }
    }

    fun pluseZoom(latLng: LatLng) {
        currentZoom = Math.min(MAX_ZOOM, ++currentZoom)
        viewState.mapZoom(latLng, currentZoom)
    }

    fun munusZoom(latLng: LatLng) {
        currentZoom = Math.max(MIN_ZOOM, --currentZoom)
        viewState.mapZoom(latLng, currentZoom)
    }

    override fun accept(location: Location) {
        currentLocation = location
    }

}
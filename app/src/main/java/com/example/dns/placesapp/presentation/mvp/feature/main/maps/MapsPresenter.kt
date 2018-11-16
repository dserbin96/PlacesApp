package com.example.dns.placesapp.presentation.mvp.feature.main.maps

import android.annotation.SuppressLint
import android.location.Location
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.example.dns.placesapp.R
import com.example.dns.placesapp.domain.global.manager.ResourceManager
import com.example.dns.placesapp.domain.global.manager.SchedulersProvider
import com.example.dns.placesapp.presentation.mvp.global.base.BasePresenter
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import io.reactivex.functions.Consumer
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider
import javax.inject.Inject

@InjectViewState
class MapsPresenter @Inject constructor(private val locationProvider: ReactiveLocationProvider,
                                        private val schedulersProvider: SchedulersProvider,
                                        private val locationRequest: LocationRequest,
                                        private val resourceManager: ResourceManager) :
        BasePresenter<MapsView>(), Consumer<Location> {

    companion object {
        private const val MAX_ZOOM = 21f
        private const val MIN_ZOOM = 0f
        private const val DEFAULT_ZOOM = 15f
    }

    private var currentLocation: Location? = null

    @SuppressLint("MissingPermission")
    fun start() {
        addToDisposable(locationProvider
                .getUpdatedLocation(locationRequest)
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe(this))
    }

    fun currentZoom() {
        currentLocation?.let {
            val latLng = LatLng(it.latitude, it.longitude)
            viewState?.addMarker(MarkerOptions()
                    .position(latLng)
                    .icon(resourceManager.getBitmapDescriptor(R.drawable.ic_current_place)))
            viewState?.mapZoom(latLng, DEFAULT_ZOOM)
        }
    }

    override fun accept(location: Location) {
        currentLocation = location
        Log.d("MapsPresenter", location.toString())
    }

}
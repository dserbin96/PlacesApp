package com.example.dns.placesapp.presentation.mvp.feature.main.maps

import android.annotation.SuppressLint
import android.location.Location
import com.arellomobile.mvp.InjectViewState
import com.example.dns.placesapp.domain.global.manager.SchedulersProvider
import com.example.dns.placesapp.presentation.mvp.global.base.ErrorHandlingPresenter
import com.example.dns.placesapp.presentation.mvp.global.error.ErrorHandler
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.maps.model.LatLng
import io.reactivex.functions.Consumer
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider
import javax.inject.Inject

@InjectViewState
class MapsPresenter @Inject constructor(private val locationProvider: ReactiveLocationProvider,
                                        private val schedulersProvider: SchedulersProvider,
                                        private val locationRequest: LocationRequest,
                                        override val errorHandler: ErrorHandler) :
        ErrorHandlingPresenter<MapsView>(), Consumer<Location> {

    companion object {
        private const val DEFAULT_ZOOM = 15f
    }

    private var currentLocation: Location? = null

    @SuppressLint("MissingPermission")
    fun start() {
        addToDisposable(locationProvider
                .getUpdatedLocation(locationRequest)
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe(this,
                        Consumer<Throwable> { t -> errorHandler.proceed(t) }))
    }

    fun currentZoom() {
        currentLocation?.let {
            val latLng = LatLng(it.latitude, it.longitude)
            viewState?.mapZoom(latLng, DEFAULT_ZOOM)
        }
    }

    override fun accept(location: Location) {
        currentLocation = location
        viewState?.currentPlaceMarker(LatLng(location.latitude, location.longitude))
    }

}
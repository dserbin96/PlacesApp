package com.example.dns.placesapp.presentation.mvp.feature.maps

import android.annotation.SuppressLint
import android.location.Location
import com.arellomobile.mvp.InjectViewState
import com.example.dns.placesapp.domain.feature.maps.SearchUseCase
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
                                        override val errorHandler: ErrorHandler,
                                        private val searchUseCase: SearchUseCase) :
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
        val latLng = currentLocation?.let { LatLng(it.latitude, it.longitude) } ?: LatLng(0.0, 0.0)
        addToDisposable(searchUseCase
                .execute(SearchUseCase.Params(latLng))
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .doOnSubscribe { viewState?.showLoading() }
                .doFinally {
                    viewState?.hideLoading()
                    viewState?.mapZoom(latLng, DEFAULT_ZOOM)
                }
                .subscribe({ },
                        { t -> errorHandler.proceed(t) }))
    }

    override fun accept(location: Location) {
        currentLocation = location
        viewState?.currentPlaceMarker(LatLng(location.latitude, location.longitude))
    }

}
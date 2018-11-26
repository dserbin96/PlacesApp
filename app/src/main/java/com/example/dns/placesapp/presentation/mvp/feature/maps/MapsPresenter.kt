package com.example.dns.placesapp.presentation.mvp.feature.maps

import android.annotation.SuppressLint
import android.location.Location
import com.arellomobile.mvp.InjectViewState
import com.example.dns.placesapp.R
import com.example.dns.placesapp.domain.feature.maps.GetPlaceUseCase
import com.example.dns.placesapp.domain.feature.maps.SearchUseCase
import com.example.dns.placesapp.domain.global.manager.ResourceManager
import com.example.dns.placesapp.domain.global.manager.SchedulersProvider
import com.example.dns.placesapp.presentation.global.mapper.PlaceDetailViewMapper
import com.example.dns.placesapp.presentation.global.mapper.PlaceViewMapper
import com.example.dns.placesapp.presentation.global.model.PlaceDetailViewModel
import com.example.dns.placesapp.presentation.global.model.PlaceViewModel
import com.example.dns.placesapp.presentation.mvp.global.DataPlaceInfo
import com.example.dns.placesapp.presentation.mvp.global.PLACE_INFO
import com.example.dns.placesapp.presentation.mvp.global.base.ErrorHandlingPresenter
import com.example.dns.placesapp.presentation.mvp.global.error.ErrorHandler
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MapsPresenter @Inject constructor(private val locationProvider: ReactiveLocationProvider,
                                        private val schedulersProvider: SchedulersProvider,
        //private val locationRequest: LocationRequest,
                                        override val errorHandler: ErrorHandler,
                                        private val searchUseCase: SearchUseCase,
                                        private val resourceManager: ResourceManager,
                                        private val placeViewMapper: PlaceViewMapper,
                                        private val getPlaceUseCase: GetPlaceUseCase,
                                        private val placeDetailViewMapper: PlaceDetailViewMapper,
                                        private val router: Router) :
        ErrorHandlingPresenter<MapsView>() {

    companion object {
        private const val DEFAULT_ZOOM = 15f
    }

    private var currentLocation: Location? = null
    private var places = mutableListOf<PlaceViewModel>()

    @SuppressLint("MissingPermission")
    fun currentLocation() {
        addToDisposable(locationProvider
                .lastKnownLocation
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe({ location ->
                    currentLocation = location
                    viewState?.currentPlaceMarker(LatLng(location.latitude, location.longitude))
                    currentZoom(location)
                }, { t -> errorHandler.proceed(t) }))
    }

    fun showPlaceInfo(place: PlaceDetailViewModel) {
        currentLocation?.let {
            router.newScreenChain(PLACE_INFO, DataPlaceInfo(place, it))
        }
    }

    fun getPlace(id: String) {
        val place = places.filter { it.id == id }.first()
        addToDisposable(getPlaceUseCase.execute(GetPlaceUseCase.Params(id))
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .doOnSubscribe { viewState?.showLoading() }
                .map { placeDetailViewMapper.mapToPlaceDetailView(it) }
                .doFinally {
                    viewState?.hideLoading()
                    viewState?.mapZoom(place.latLng)
                }
                .subscribe({ model ->
                    run {
                        model?.let {
                            viewState?.showPlace(it, currentLocation ?: Location(""))
                        }
                    }
                }, { errorHandler.proceed(it) }))
    }

    private fun currentZoom(location: Location) {
        val latLng = LatLng(location.latitude, location.longitude)
        addToDisposable(searchUseCase
                .execute(SearchUseCase.Params(latLng))
                .subscribeOn(schedulersProvider.io())
                .map { places -> places.map { placeViewMapper.mapToPlaceView(it) } }
                .observeOn(schedulersProvider.ui())
                .doOnSubscribe { viewState?.showLoading() }
                .doFinally {
                    viewState?.hideLoading()
                    viewState?.mapZoom(latLng, DEFAULT_ZOOM)
                }
                .subscribe({ places -> places?.let { addPlace(it) } },
                        { t -> errorHandler.proceed(t) }))//todo ErrorModel
    }

    private fun addPlace(places: List<PlaceViewModel>) {
        this.places.clear()
        this.places.addAll(places)
        places.forEach { place ->
            place.let {
                val options = MarkerOptions()
                        .position(it.latLng)
                        .title(it.name)
                        .icon(resourceManager.getBitmapDescriptor(R.drawable.ic_oval_orange))
                viewState?.addMarker(options, it.id)
            }
        }
    }

}
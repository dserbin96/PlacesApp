package com.example.dns.placesapp.presentation.ui.feature.maps

import android.Manifest
import android.location.Location
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.global.model.PlaceDetailViewModel
import com.example.dns.placesapp.presentation.mvp.feature.maps.MapsPresenter
import com.example.dns.placesapp.presentation.mvp.feature.maps.MapsView
import com.example.dns.placesapp.presentation.ui.global.base.BaseFragment
import com.example.dns.placesapp.presentation.ui.global.delegetes.LoaderDelegate
import com.example.dns.placesapp.presentation.ui.global.expansion.visibile
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_maps.*
import kotlinx.android.synthetic.main.layout_place_card.*
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider

class MapsFragment : BaseFragment(), MapsView,
        OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnMapLongClickListener {

    companion object {
        fun getInstance() = MapsFragment()
    }

    @Inject
    lateinit var providePresenter: Provider<MapsPresenter>

    @Inject
    lateinit var loaderDelegate: LoaderDelegate

    @InjectPresenter
    lateinit var presenter: MapsPresenter

    @ProvidePresenter
    fun providePresenter(): MapsPresenter = providePresenter.get()

    private lateinit var mMap: GoogleMap
    private lateinit var mapFragment: SupportMapFragment
    private var currentPlaceMarker: Marker? = null

    private val completableDisposable = CompositeDisposable()

    override fun layoutRes() = R.layout.fragment_maps

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVew()
        initPermission()
    }

    override fun onDestroy() {
        super.onDestroy()
        completableDisposable.dispose()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnMapLongClickListener(this)
        mMap.setOnMarkerClickListener(this)
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        marker?.let {
            presenter.getPlace(marker.tag as String)
        }
        return true
    }

    override fun onMapLongClick(latLng: LatLng?) {
        Timber.d(latLng.toString())
    }

    override fun mapZoom(latLng: LatLng, zoom: Float) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom))
    }

    override fun mapZoom(latLng: LatLng) {
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
    }

    override fun addMarker(options: MarkerOptions, id: String) {
        mMap.addMarker(options).apply {
            tag = id
        }
    }

    override fun currentPlaceMarker(latLng: LatLng) {
        if (currentPlaceMarker != null) {
            currentPlaceMarker?.position = latLng
        } else {
            currentPlaceMarker = mMap.addMarker(MarkerOptions()
                    .position(latLng)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_current_place)))
        }
    }

    override fun showPlace(model: PlaceDetailViewModel, myLocation: Location) {
        cardPlace.visibile()
        Glide.with(this).load(model.basePhoto).into(ivPlace)
        tvName.text = model.name
        model.rating?.let { rbPlace.rating = it } ?: let { rbPlace.visibile(false) }
        tvStreat.text = model.address
        tvTimeWork.text = model.timeWorks?.get(0)//todo ориентироваться по времени
        val location = Location(model.name)
        tvDistancePlace.text = "${location.distanceTo(myLocation)}"
    }

    override fun showError(error: String) {
        showTopSnackBar(error)
    }

    override fun showLoading() {
        loaderDelegate.showLoading()
    }

    override fun hideLoading() {
        loaderDelegate.hideLoading()
    }

    private fun initVew() {
        mapFragment = childFragmentManager.findFragmentById(R.id.fMap)
                as SupportMapFragment
        mapFragment.getMapAsync(this)

        fabCurrentLocation.setOnClickListener { presenter.currentZoom() }

        fabMinus.setOnClickListener {
            with(mMap.cameraPosition) { mapZoom(target, zoom - 1) }
        }

        fabPlus.setOnClickListener {
            with(mMap.cameraPosition) { mapZoom(target, zoom + 1) }
        }

        cardPlace.setOnClickListener {
            presenter.showPlaceInfo()
        }
    }

    private fun initPermission() {
        completableDisposable.add(RxPermissions(this)
                .request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe { presenter.start() })
    }

}
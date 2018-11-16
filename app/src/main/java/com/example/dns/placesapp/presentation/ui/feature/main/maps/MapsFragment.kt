package com.example.dns.placesapp.presentation.ui.feature.main.maps

import android.Manifest
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.mvp.feature.main.maps.MapsPresenter
import com.example.dns.placesapp.presentation.mvp.feature.main.maps.MapsView
import com.example.dns.placesapp.presentation.ui.global.base.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_maps.*
import javax.inject.Inject
import javax.inject.Provider

class MapsFragment : BaseFragment(), OnMapReadyCallback, MapsView {

    companion object {
        fun getInstance() = MapsFragment()
    }

    @Inject
    lateinit var providePresenter: Provider<MapsPresenter>

    @InjectPresenter
    lateinit var presenter: MapsPresenter

    @ProvidePresenter
    fun providePresenter(): MapsPresenter = providePresenter.get()

    private lateinit var mMap: GoogleMap
    private lateinit var mapFragment: SupportMapFragment

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
    }

    override fun mapZoom(latLng: LatLng, zoom: Float) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom))
    }

    override fun addMarker(options: MarkerOptions) {
        mMap.addMarker(options)
    }

    private fun initVew() {
        mapFragment = childFragmentManager.findFragmentById(R.id.fMap)
                as SupportMapFragment
        mapFragment.getMapAsync(this)

        fabCurrentLocation.setOnClickListener {
            presenter.currentZoom()
        }

        fabMinus.setOnClickListener {
            with(mMap.cameraPosition) { mapZoom(target, zoom - 1) }
        }

        fabPlus.setOnClickListener {
            with(mMap.cameraPosition) { mapZoom(target, zoom + 1) }
        }
    }

    private fun initPermission() {
        completableDisposable.add(RxPermissions(this)
                .request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe { presenter.start() })
    }

}
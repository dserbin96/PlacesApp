package com.example.dns.placesapp.presentation.ui.feature.main.maps

import android.os.Bundle
import android.view.View
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.mvp.feature.main.maps.MapsView
import com.example.dns.placesapp.presentation.ui.global.base.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.fragment_maps.*

class MapsFragment : BaseFragment(), OnMapReadyCallback, MapsView {

    companion object {
        fun getInstance() = MapsFragment()
    }

    private lateinit var mMap: GoogleMap
    private lateinit var mapFragment: SupportMapFragment
    //todo inject
    //private lateinit var presenter: MapsPresenter

    override fun layoutRes() = R.layout.fragment_maps

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVew()
        /*val loacationProvider = ReactiveLocationProvider(context)
        presenter = MapsPresenter(loacationProvider)
        presenter.start()*/
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }

    private fun initVew() {
        mapFragment = childFragmentManager.findFragmentById(R.id.fMap)
                as SupportMapFragment
        mapFragment.getMapAsync(this)

        fabCurrentLocation.setOnClickListener {
            //presenter.currentZoom()
        }
    }

    override fun mapZoom(latLng: LatLng, zoom: Float) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom))
    }

}
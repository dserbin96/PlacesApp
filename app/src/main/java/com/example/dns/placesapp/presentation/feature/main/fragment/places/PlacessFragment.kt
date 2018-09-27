package com.example.dns.placesapp.presentation.feature.main.fragment.places

import android.support.v4.app.Fragment
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.base.BaseFragment

class PlacessFragment : BaseFragment(), PlacesView {

    companion object {
        fun getInstance(): Fragment {
            return PlacessFragment()
        }
    }

    override fun layoutRes() = R.layout.fragment_places

}
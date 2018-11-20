package com.example.dns.placesapp.presentation.ui.feature.place_info

import android.os.Bundle
import android.view.View
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.ui.global.base.BaseFragment

class PlaceInfoFragment : BaseFragment() {

    companion object {
        fun getInstance() = PlaceInfoFragment()
    }

    override fun layoutRes() = R.layout.fragment_place_info

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
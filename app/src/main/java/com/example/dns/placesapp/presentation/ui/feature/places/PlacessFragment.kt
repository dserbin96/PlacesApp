package com.example.dns.placesapp.presentation.ui.feature.places

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.ui.global.base.BaseFragment
import com.example.dns.placesapp.presentation.mvp.feature.places.page.PlacesView
import kotlinx.android.synthetic.main.fragment_places.*

class PlacessFragment : BaseFragment(), PlacesView {

    companion object {
        fun getInstance(): Fragment {
            return PlacessFragment()
        }
    }

    override fun layoutRes() = R.layout.fragment_places

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initActionBar()
    }

    override fun showTitle(title: String) {
        activity?.title = title
    }

    private fun initActionBar(){
        activity?.setActionBar(toolbar)
        showTitle("Краснодар")
        tabPlaces.setupWithViewPager(vpPlaces)
    }

}
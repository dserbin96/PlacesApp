package com.example.dns.placesapp.presentation.feature.main.fragment.places

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.base.BaseFragment
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
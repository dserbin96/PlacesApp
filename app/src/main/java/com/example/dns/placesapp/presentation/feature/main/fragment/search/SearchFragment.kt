package com.example.dns.placesapp.presentation.feature.main.fragment.search

import android.support.v4.app.Fragment
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.base.BaseFragment

class SearchFragment : BaseFragment(), SearchView {

    companion object {
        fun getInstance(): Fragment {
            return SearchFragment()
        }
    }

    override fun layoutRes() = R.layout.fragment_search

}
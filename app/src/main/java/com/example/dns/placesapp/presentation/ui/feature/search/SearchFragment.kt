package com.example.dns.placesapp.presentation.ui.feature.search

import android.support.v4.app.Fragment
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.ui.global.base.BaseFragment
import com.example.dns.placesapp.presentation.mvp.feature.search.SearchView

class SearchFragment : BaseFragment(), SearchView {

    companion object {
        fun getInstance(): Fragment {
            return SearchFragment()
        }
    }

    override fun layoutRes() = R.layout.fragment_search

}
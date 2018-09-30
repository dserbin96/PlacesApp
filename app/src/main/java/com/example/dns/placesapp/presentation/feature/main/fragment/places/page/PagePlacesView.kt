package com.example.dns.placesapp.presentation.feature.main.fragment.places.page

import com.example.dns.placesapp.presentation.base.BaseView
import com.example.dns.placesapp.presentation.model.PlaceViewModel

interface PagePlacesView : BaseView {
    fun showList(list: List<PlaceViewModel>)
}
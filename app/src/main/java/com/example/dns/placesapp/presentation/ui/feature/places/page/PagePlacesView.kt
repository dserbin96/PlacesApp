package com.example.dns.placesapp.presentation.ui.feature.places.page

import com.example.dns.placesapp.presentation.mvp.global.base.BaseView
import com.example.dns.placesapp.presentation.global.model.PlaceViewModel

interface PagePlacesView : BaseView {
    fun showList(list: List<PlaceViewModel>)
}
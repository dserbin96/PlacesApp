package com.example.dns.placesapp.presentation.mvp.global

import com.example.dns.placesapp.presentation.global.model.PlaceDetailViewModel

const val MAPS = "MAPS"
const val PLACES = "PLACES"
const val SEARCH = "SEARCH"
const val PLACE_INFO = "PLACE_INFO"

data class DataPlaceInfo(val place:PlaceDetailViewModel)
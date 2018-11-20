package com.example.dns.placesapp.presentation.global.model

import com.example.dns.placesapp.domain.global.entity.CategoryEntity
import com.google.android.gms.maps.model.LatLng

data class PlaceViewModel(val id: String,
                          val name: String?,
                          val referraIld: String?,
                          val latLng: LatLng,
                          val address: String?,
                          val street: String?,
                          val city: String?,
                          val country: String?,
                          val categories: List<CategoryEntity>?,
                          var isFavorites: Boolean = false)
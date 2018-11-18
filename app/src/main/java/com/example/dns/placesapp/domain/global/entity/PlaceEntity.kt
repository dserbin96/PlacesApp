package com.example.dns.placesapp.domain.global.entity

import com.google.android.gms.maps.model.LatLng

data class PlaceEntity(val id: String,
                       val name: String,
                       val referraIld: String,
                       val latLng: LatLng,
                       val address: String,
                       val street: String,
                       val city: String,
                       val country: String,
                       val categories: List<CategoryEntity>)
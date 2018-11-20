package com.example.dns.placesapp.presentation.global.model

import com.google.android.gms.maps.model.LatLng

data class PlaceDetailViewModel(val id: String,
                                val name: String,
                                val latLng: LatLng?,
                                val address: String?,
                                val rating: Float?,
                                val photosPath: List<String>?,
                                val timeWorks: List<String>?,
                                val basePhoto: String?)
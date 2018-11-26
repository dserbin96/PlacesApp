package com.example.dns.placesapp.domain.global.entity

import com.google.android.gms.maps.model.LatLng

data class PlaceDetailEntity(val id: String,
                             val name: String,
                             val latLng: LatLng?,
                             val address: String?,
                             val categories: List<CategoryEntity>?,
                             val rating: Float?,
                             val photosPath: List<String>?,
                             val basePhoto: String?,
                             val isOpen: Boolean?,
                             val timeWork: String?,
                             val description: String?)
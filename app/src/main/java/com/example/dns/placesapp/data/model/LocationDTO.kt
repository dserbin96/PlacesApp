package com.example.dns.placesapp.data.model

import com.google.gson.annotations.SerializedName

data class LocationDTO(val address: String,
                       val crossStreet: String,
                       val lat: Double,
                       val lng: Double,
                       @SerializedName("labeledLatLngs")
                       val listLableLatLng: List<LabelLatLng>,
                       val distance: Int,
                       val cc: String,
                       val city: String,
                       val state: String,
                       val country: String,
                       val formattedAdress: List<String>?)
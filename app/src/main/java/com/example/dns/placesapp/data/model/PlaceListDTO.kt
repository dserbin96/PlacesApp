package com.example.dns.placesapp.data.model

import com.google.gson.annotations.SerializedName

data class PlaceListDTO(@SerializedName("venues")
                        val places: List<PlaceDTO>,
                        val confident: Boolean)
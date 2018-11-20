package com.example.dns.placesapp.data.model

import com.google.gson.annotations.SerializedName

data class VenuesDTO<T>(@SerializedName("venues")
                        val venues: T)

data class VenueDTO<T>(@SerializedName("venue")
                       val venue: T)

data class PlacesDTO<T>(@SerializedName("places")
                        val places: T)
package com.example.dns.placesapp.data.model

data class PlacesPhotoDTO(val count: Short,
                          val items: List<PhotoDTO>,
                          val dupesRemoved: Short)
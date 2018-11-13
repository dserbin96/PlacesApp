package com.example.dns.placesapp.presentation.global.model

data class PlaceViewModel(var id: Int,
                          var imagePath: String?,
                          var name: String?,
                          var adress: String?,
                          var timeWork: String?,
                          var isFavorites: Boolean = false)
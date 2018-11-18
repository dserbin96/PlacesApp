package com.example.dns.placesapp.data.model

data class PlaceDTO(val id: String,
                    val name: String,
                    val referralId: String,
                    val location: LocationDTO,
                    val categories: List<CategoryDTO>,
                    val hasPerk: Boolean)
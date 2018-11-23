package com.example.dns.placesapp.data.model

import com.google.gson.annotations.SerializedName

data class PlaceDetailDTO(val id: String,
                          val name: String,
                          val location: LocationDTO?,
                          val categories: List<CategoryDTO>?,
                          val rating: Float?,
                          val ratingColor: String?,
                          val photos: PlacesPhotoDTO?,
                          @SerializedName("popular")
                          val timeWork: WeekDTO?,
                          val bestPhoto: PhotoDTO?)
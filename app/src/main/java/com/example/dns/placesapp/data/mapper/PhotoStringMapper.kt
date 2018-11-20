package com.example.dns.placesapp.data.mapper

import com.example.dns.placesapp.data.model.PhotoDTO
import javax.inject.Inject

class PhotoStringMapper @Inject constructor() {

    fun mapToString(photo: PhotoDTO?) = photo?.let {
        "${photo.prefix}${photo.width}x${photo.height}${photo.suffix}"
    }.orEmpty()
}
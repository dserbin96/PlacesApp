package com.example.dns.placesapp.presentation.global.mapper

import android.annotation.SuppressLint
import com.example.dns.placesapp.domain.global.entity.PlaceDetailEntity
import com.example.dns.placesapp.presentation.global.model.PlaceDetailViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class PlaceDetailViewMapper @Inject constructor() {

    @SuppressLint("SimpleDateFormat")
    fun mapToPlaceDetailView(place: PlaceDetailEntity?)
            : PlaceDetailViewModel? {
        val dataFormat = SimpleDateFormat("hh:mm aa")
        var time: Calendar? = null
        place?.timeWork?.let {
            val index = it.indexOf("–")
            val str = it.substring(index + 1, it.length)
            time = Calendar.getInstance()
            time?.time = dataFormat.parse(str)
        }
        return PlaceDetailViewModel(place?.id.orEmpty(),
                place?.name.orEmpty(),
                place?.latLng,
                place?.address,
                place?.rating,
                place?.photosPath,
                place?.basePhoto,
                place?.isOpen,
                time,
                place?.description)
    }

}
package com.example.dns.placesapp.domain.global.manager

import android.content.Context
import android.support.v4.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptorFactory

class ResourceManager(private val context: Context) {

    fun getString(idString: Int) = context.getString(idString)

    fun getDrawable(idDrawable: Int) = ContextCompat.getDrawable(context, idDrawable)

    fun getBitmapDescriptor(idDrawable: Int) = BitmapDescriptorFactory
            .fromResource(idDrawable)

}
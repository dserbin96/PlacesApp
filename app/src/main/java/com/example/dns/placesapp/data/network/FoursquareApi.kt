package com.example.dns.placesapp.data.network

import com.example.dns.placesapp.data.model.PlaceListDTO
import com.example.dns.placesapp.data.model.ResponseDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FoursquareApi {

    @GET("/v2/venues/search/")
    fun searchPlace(@Query("ll") latLng: String): Single<ResponseDTO<PlaceListDTO>>

}
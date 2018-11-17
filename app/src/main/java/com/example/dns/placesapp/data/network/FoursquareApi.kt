package com.example.dns.placesapp.data.network

import io.reactivex.Completable
import retrofit2.http.GET
import retrofit2.http.Query

interface FoursquareApi {

    @GET("/v2/venues/search/")
    fun searchPlace(@Query("ll") latLng: String): Completable

}
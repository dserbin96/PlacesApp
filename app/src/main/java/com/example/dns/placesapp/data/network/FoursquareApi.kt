package com.example.dns.placesapp.data.network

import com.example.dns.placesapp.data.model.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FoursquareApi {

    @GET("/v2/venues/search/")
    fun searchPlace(@Query("ll") latLng: String):
            Single<ResponseDTO<VenuesDTO<List<PlaceDTO>>>>

    @GET("/v2/venues/{place_id}")
    fun getPlaceDeatail(@Path("place_id") placeId: String):
            Single<ResponseDTO<VenueDTO<PlaceDetailDTO>>>

    @GET("/v2/venues/{place_id}/photos")
    fun getPlacePhotos(@Path("place_id") placeId: String):
            Single<ResponseDTO<PlacesDTO<PlacesPhotoDTO>>>

}
package com.example.dns.placesapp.data.model

import com.google.gson.annotations.SerializedName

data class ResponseDTO<T>(
        @SerializedName("meta")
        val meta: MetaDTO,
        @SerializedName("response")
        val response: T?)
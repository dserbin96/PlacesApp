package com.example.dns.placesapp.data.model

import com.google.gson.annotations.SerializedName

data class MetaDTO(
        @SerializedName("code")
        private val code: Short,
        @SerializedName("errorType")
        private val errorType: String?,
        @SerializedName("errorDetail")
        private val message: String?,
        @SerializedName("requestId")
        private val requestId: String)
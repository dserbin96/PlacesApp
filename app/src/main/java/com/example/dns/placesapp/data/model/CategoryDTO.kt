package com.example.dns.placesapp.data.model

import com.google.gson.annotations.SerializedName

data class CategoryDTO(
        @SerializedName("id")
        val categoryId: String,
        val name: String,
        val pluralName: String,
        val shortName: String,
        val icon: Icon)
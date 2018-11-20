package com.example.dns.placesapp.data.model

data class DayWeekDTO(val days: String,
                      val includesToday: Boolean,
                      val open: List<TimeWorkDTO>)
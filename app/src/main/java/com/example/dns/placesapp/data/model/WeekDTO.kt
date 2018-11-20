package com.example.dns.placesapp.data.model

data class WeekDTO(val isOpen: Boolean,
                   val isLocationHoliday: Boolean,
                   val timeframes: List<DayWeekDTO>)
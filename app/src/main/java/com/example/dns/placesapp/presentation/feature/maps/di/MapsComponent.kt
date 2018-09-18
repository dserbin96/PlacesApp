package com.example.dns.placesapp.presentation.feature.maps.di

import com.example.dns.placesapp.presentation.feature.maps.MapsActivity
import dagger.Component
import dagger.android.AndroidInjector

@Component(modules = [MapsModul::class])
interface MapsComponent {

    @Component.Builder
    abstract class Builde : AndroidInjector<MapsActivity>
}
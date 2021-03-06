package com.example.dns.placesapp.di

import com.example.dns.placesapp.PlacesApp
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun injectApp(app: PlacesApp)
}
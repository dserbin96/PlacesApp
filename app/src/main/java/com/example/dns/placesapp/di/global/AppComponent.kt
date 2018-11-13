package com.example.dns.placesapp.di.global

import com.example.dns.placesapp.PlacesApp
import dagger.Component

@Component(modules = [AppModule::class, AppScBuilderModule::class, NavigationModule::class])
interface AppComponent {
    fun injectApp(app: PlacesApp)
}
package com.example.dns.placesapp.di.global.companent

import com.example.dns.placesapp.PlacesApp
import com.example.dns.placesapp.di.global.module.AppModule
import com.example.dns.placesapp.di.global.module.AppScBuilderModule
import com.example.dns.placesapp.di.global.module.NavigationModule
import dagger.Component

@Component(modules = [AppModule::class, AppScBuilderModule::class, NavigationModule::class])
interface AppComponent {
    fun injectApp(app: PlacesApp)
}
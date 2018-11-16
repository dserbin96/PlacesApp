package com.example.dns.placesapp.di.global.companent

import com.example.dns.placesapp.PlacesApp
import com.example.dns.placesapp.di.global.module.AppModule
import com.example.dns.placesapp.di.global.module.BuilderModule
import com.example.dns.placesapp.di.global.module.NavigationModule
import com.example.dns.placesapp.di.global.scope.PerApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(modules = [AppModule::class,
    BuilderModule::class,
    NavigationModule::class,
    AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<PlacesApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<PlacesApp>()

}
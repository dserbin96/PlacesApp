package com.example.dns.placesapp.di.global.module

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

@Module
class NavigationModule {

    private var cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    fun provideNavigationHolder() = cicerone.navigatorHolder

    @Provides
    fun provideRouter() = cicerone.router

}
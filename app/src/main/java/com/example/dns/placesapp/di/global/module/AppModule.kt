package com.example.dns.placesapp.di.global.module

import android.content.Context
import com.example.dns.placesapp.PlacesApp
import com.example.dns.placesapp.di.global.scope.PerApplication
import com.example.dns.placesapp.domain.global.manager.ResourceManager
import com.example.dns.placesapp.domain.global.manager.SchedulersProvider
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @PerApplication
    @Provides
    fun provideContext(application: PlacesApp): Context = application

    @PerApplication
    @Provides
    fun provideResourceManager(context: Context) = ResourceManager(context)

    @PerApplication
    @Provides
    fun provideSchedulerProvider() = SchedulersProvider()

}
package com.example.dns.placesapp.presentation.feature.main.di

import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun provideMessage() = "World Hello"

}
package com.example.dns.placesapp.di.global.module

import com.example.dns.placesapp.data.reposiories.PlaceRepositoryImpl
import com.example.dns.placesapp.di.global.scope.PerApplication
import com.example.dns.placesapp.domain.global.repositories.PlaceRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @PerApplication
    @Binds
    fun provideSearchRepository(repository: PlaceRepositoryImpl): PlaceRepository

}
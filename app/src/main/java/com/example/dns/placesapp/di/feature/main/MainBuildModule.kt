package com.example.dns.placesapp.di.feature.main

import com.example.dns.placesapp.di.feature.maps.MapsViewModule
import com.example.dns.placesapp.di.global.scope.PerFragment
import com.example.dns.placesapp.presentation.ui.feature.maps.MapsFragment
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module(includes = arrayOf(AndroidInjectionModule::class))
interface MainBuildModule {

    @PerFragment
    @ContributesAndroidInjector(modules = arrayOf(MapsViewModule::class))
    fun provideMapsFragment(): MapsFragment

}
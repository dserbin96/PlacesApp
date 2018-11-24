package com.example.dns.placesapp.di.feature.place_info

import com.example.dns.placesapp.di.global.scope.PerFragment
import com.example.dns.placesapp.presentation.ui.feature.place_info.PlaceInfoFragment
import dagger.Module
import dagger.Provides

@Module
class PlaceInfoViewModule {

    @PerFragment
    @Provides
    fun provideModel(fragment: PlaceInfoFragment) = fragment.getArgumentModel()


    @PerFragment
    @Provides
    fun provideLocation(fragment: PlaceInfoFragment) = fragment.getArgumentLocation()


}
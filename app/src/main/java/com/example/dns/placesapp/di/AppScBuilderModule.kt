package com.example.dns.placesapp.di

import com.example.dns.placesapp.presentation.feature.maps.MapsActivity
import com.example.dns.placesapp.presentation.feature.maps.di.MapsComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [MapsComponent::class])
abstract class AppScBuilderModule {

    @Binds
    @IntoMap
    @ActivityKey(MapsActivity::class)
    abstract fun bindMapsActivityComponent(builder: MapsComponent.Builde)

}
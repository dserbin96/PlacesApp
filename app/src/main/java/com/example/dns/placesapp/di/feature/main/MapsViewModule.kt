package com.example.dns.placesapp.di.feature.main

import android.content.Context
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationSettingsRequest
import dagger.Module
import dagger.Provides
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider
import pl.charmas.android.reactivelocation2.ReactiveLocationProviderConfiguration

@Module
class MapsViewModule {

    @Provides
    fun provideReactiveLocationProvider(context: Context,
                                        configuration: ReactiveLocationProviderConfiguration) =
            ReactiveLocationProvider(context, configuration)


    @Provides
    fun provideReactiveLocationProviderConfiguration() =
            ReactiveLocationProviderConfiguration
                    .builder()
                    .setRetryOnConnectionSuspended(true)
                    .build()

    @Provides
    fun provideLocationRequest() =
            LocationRequest.create()
                    .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                    .setNumUpdates(50)
                    .setInterval(100)

    @Provides
    fun provideLocationSettingsRequest(locationRequest: LocationRequest) = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)
            .setAlwaysShow(true)
            .build()

}
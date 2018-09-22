package com.example.dns.placesapp.di

import android.app.Activity
import com.example.dns.placesapp.presentation.feature.main.MainActivity
import com.example.dns.placesapp.presentation.feature.main.di.MainComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainComponent::class])
abstract class AppScBuilderModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindMainActivityComponent(builder: MainComponent.Builde):
            AndroidInjector.Factory<out Activity>

}
package com.example.dns.placesapp.di.global.module

import android.app.Activity
import com.example.dns.placesapp.di.feature.main.MainComponent
import com.example.dns.placesapp.presentation.ui.feature.main.MainActivity
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
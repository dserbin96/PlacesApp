package com.example.dns.placesapp.presentation.feature.main.di

import com.example.dns.placesapp.presentation.feature.main.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MainModule::class])
interface MainComponent:AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builde : AndroidInjector.Builder<MainActivity>()
}
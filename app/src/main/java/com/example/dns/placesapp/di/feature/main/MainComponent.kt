package com.example.dns.placesapp.di.feature.main

import com.example.dns.placesapp.presentation.ui.feature.main.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MainModule::class])
interface MainComponent:AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builde : AndroidInjector.Builder<MainActivity>()
}
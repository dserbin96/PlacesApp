package com.example.dns.placesapp

import com.example.dns.placesapp.di.global.companent.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class PlacesApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>
            = DaggerAppComponent.builder().create(this)
}
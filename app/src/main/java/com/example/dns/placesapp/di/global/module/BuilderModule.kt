package com.example.dns.placesapp.di.global.module

import com.example.dns.placesapp.di.feature.main.MainBuildModule
import com.example.dns.placesapp.di.feature.main.MainViewModule
import com.example.dns.placesapp.di.global.scope.PerActivity
import com.example.dns.placesapp.presentation.ui.feature.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface BuilderModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainViewModule::class, MainBuildModule::class))
    fun provideMainActiity(): MainActivity

}
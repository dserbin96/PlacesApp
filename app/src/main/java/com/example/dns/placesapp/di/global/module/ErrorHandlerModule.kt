package com.example.dns.placesapp.di.global.module

import com.example.dns.placesapp.di.global.scope.PerApplication
import com.example.dns.placesapp.presentation.mvp.global.error.DefaultErrorHandler
import com.example.dns.placesapp.presentation.mvp.global.error.ErrorHandler
import dagger.Binds
import dagger.Module

@Module
interface ErrorHandlerModule {

    @PerApplication
    @Binds
    fun provideErrorHandler(errorHandler: DefaultErrorHandler): ErrorHandler

}
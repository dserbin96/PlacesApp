package com.example.dns.placesapp.presentation.mvp.global.error

interface ErrorHandler {
    fun proceed(error: Throwable)
    fun attachView(view: CanShowError)
    fun detachView()
}
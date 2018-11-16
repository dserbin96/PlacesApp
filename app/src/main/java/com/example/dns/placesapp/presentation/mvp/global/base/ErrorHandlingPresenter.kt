package com.example.dns.placesapp.presentation.mvp.global.base

import com.example.dns.placesapp.presentation.mvp.global.error.CanShowError
import com.example.dns.placesapp.presentation.mvp.global.error.ErrorHandler

abstract class ErrorHandlingPresenter<V> : BasePresenter<V>() where V : BaseView, V : CanShowError {

    abstract val errorHandler: ErrorHandler

    override fun attachView(view: V) {
        super.attachView(view)
        errorHandler.attachView(view)
    }

    override fun detachView(view: V) {
        super.detachView(view)
        errorHandler.detachView()
    }
}
package com.example.dns.placesapp.domain.global.base

import io.reactivex.Completable

abstract class CompletableUseCase<in PARAMS> : DisposableUseCase {

    fun execute(onComplete: (() -> Unit)? = {}, onError: ((Throwable) -> Unit)? = {}, params: PARAMS) {
        build(params).subscribe(onComplete, onError)
    }

    fun execute(params: PARAMS) = build(params)

    abstract fun build(params: PARAMS): Completable

}
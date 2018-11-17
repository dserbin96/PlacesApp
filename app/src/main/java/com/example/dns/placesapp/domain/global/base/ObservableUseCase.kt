package com.example.dns.placesapp.domain.global.base

import io.reactivex.Observable

abstract class ObservableUseCase<in PARAMS, RESULT> : DisposableUseCase {

    fun execute(onNext: ((RESULT) -> Unit)? = {},
                onError: ((Throwable) -> Unit)? = {},
                onComplete: (() -> Unit)? = {},
                parameters: PARAMS) {

        addDisposable(build(parameters).subscribe(onNext, onError, onComplete))

    }

    fun execute(parameters: PARAMS) = build(parameters)

    abstract fun build(parameters: PARAMS): Observable<RESULT>

}
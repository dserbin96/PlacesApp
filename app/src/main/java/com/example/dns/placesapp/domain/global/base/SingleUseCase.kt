package com.example.dns.placesapp.domain.global.base

import io.reactivex.Single

abstract class SingleUseCase<in PARAMS, RESULT> : DisposableUseCase {

    fun execute(onSuccess: ((RESULT) -> Unit)? = {},
                onError: ((Throwable) -> Unit)? = {},
                parametrs: PARAMS) {
        addDisposable(build(parametrs).subscribe(onSuccess, onError))
    }

    fun execute(parametrs: PARAMS) = build(parametrs)

    abstract fun build(parametrs: PARAMS): Single<RESULT>

}
package com.example.dns.placesapp.domain.global.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface DisposableUseCase {

    var disposable: CompositeDisposable

    fun dispose(){
        if(!disposable.isDisposed){
            disposable.dispose()
        }
    }

    fun addDisposable(disposable: Disposable){
        this.disposable.add(disposable)
    }

}
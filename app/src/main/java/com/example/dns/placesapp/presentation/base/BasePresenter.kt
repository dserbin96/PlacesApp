package com.example.dns.placesapp.presentation.base

import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<V : BaseView> : MvpPresenter<V>() {

    private val completableDisposable = CompositeDisposable()

    override fun detachView(view: V) {
        super.detachView(view)
        completableDisposable.clear()
    }

    protected fun addToDisposable(disposable: Disposable){
        completableDisposable.add(disposable)
    }

}
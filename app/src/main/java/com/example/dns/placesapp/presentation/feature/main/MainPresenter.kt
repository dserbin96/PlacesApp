package com.example.dns.placesapp.presentation.feature.main

import com.arellomobile.mvp.InjectViewState
import com.example.dns.placesapp.presentation.base.BasePresenter
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(val message: String) : BasePresenter<MainView>() {

    fun click() {
        Single.just(message)
                .subscribeOn(Schedulers.io())
                .delay(5000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading() }
                .doFinally { viewState.hideLoaging() }
                .subscribe({
                    viewState.showMessage(it)
                }, {
                    viewState.showMessage("error")
                })
    }
}
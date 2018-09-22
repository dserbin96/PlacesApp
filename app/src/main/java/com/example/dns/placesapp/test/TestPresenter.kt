package com.example.dns.placesapp.test

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@InjectViewState
class TestPresenter : MvpPresenter<TestView>() {

    fun click() {
        Single.just("Hello World")
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

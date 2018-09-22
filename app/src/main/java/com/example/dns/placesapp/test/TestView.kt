package com.example.dns.placesapp.test

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface TestView : MvpView {
    fun showLoading()
    fun hideLoaging()
    fun showMessage(message:String)
}

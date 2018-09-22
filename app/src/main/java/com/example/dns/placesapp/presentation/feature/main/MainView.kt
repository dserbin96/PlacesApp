package com.example.dns.placesapp.presentation.feature.main

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.dns.placesapp.presentation.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : BaseView {
    fun showLoading()
    fun hideLoaging()
    fun showMessage(message:String)
}
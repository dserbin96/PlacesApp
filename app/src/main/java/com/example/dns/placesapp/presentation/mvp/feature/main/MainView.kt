package com.example.dns.placesapp.presentation.mvp.feature.main

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.dns.placesapp.presentation.mvp.global.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : BaseView {
}
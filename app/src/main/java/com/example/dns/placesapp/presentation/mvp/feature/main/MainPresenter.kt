package com.example.dns.placesapp.presentation.mvp.feature.main

import com.arellomobile.mvp.InjectViewState
import com.example.dns.placesapp.presentation.mvp.global.base.BasePresenter
import com.example.dns.placesapp.presentation.mvp.global.MAPS
import com.example.dns.placesapp.presentation.mvp.global.PLACES
import com.example.dns.placesapp.presentation.mvp.global.SEARCH
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(private val router: Router) : BasePresenter<MainView>() {

    fun start() {
        router.newRootScreen(MAPS)
    }

    fun navigateTo(position: Int) {
        router.newRootScreen(
                when (position) {
                    0 -> SEARCH
                    1 -> PLACES
                    2 -> MAPS
                    else -> MAPS
                })
    }

}
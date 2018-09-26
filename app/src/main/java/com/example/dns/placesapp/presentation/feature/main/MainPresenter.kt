package com.example.dns.placesapp.presentation.feature.main

import com.arellomobile.mvp.InjectViewState
import com.example.dns.placesapp.presentation.base.BasePresenter
import com.example.dns.placesapp.util.MAPS
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(private val router: Router) : BasePresenter<MainView>() {

    fun start() {
        router.newRootScreen(MAPS)
    }

}
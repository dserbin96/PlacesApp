package com.example.dns.placesapp.presentation.mvp.feature.place_info

import android.location.Location
import com.arellomobile.mvp.InjectViewState
import com.example.dns.placesapp.di.global.module.AppModule_ProvideSchedulerProviderFactory
import com.example.dns.placesapp.domain.global.manager.SchedulersProvider
import com.example.dns.placesapp.domain.global.repositories.PlaceRepository
import com.example.dns.placesapp.presentation.global.model.PlaceDetailViewModel
import com.example.dns.placesapp.presentation.mvp.global.base.BasePresenter
import com.example.dns.placesapp.presentation.mvp.global.base.ErrorHandlingPresenter
import com.example.dns.placesapp.presentation.mvp.global.error.ErrorHandler
import io.reactivex.functions.Consumer
import javax.inject.Inject

@InjectViewState
class PlaceInfoPresenter @Inject constructor(private val model: PlaceDetailViewModel?,
                                             private val location: Location?,
                                             private val placeRepository: PlaceRepository,
                                             private val schedulersProvider: SchedulersProvider,
                                             override val errorHandler: ErrorHandler) :
        ErrorHandlingPresenter<PlaceView>() {


    fun start() {
        if (model != null && location != null) {
            viewState?.showInfo(model, location)
            getPhotos(model.id)
        }
    }

    private fun getPhotos(id: String) {
        addToDisposable(placeRepository.getListPhoto(id)
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe({ viewState?.showPhoto(it) },
                        { errorHandler.proceed(it) }))
    }

}
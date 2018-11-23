package com.example.dns.placesapp.presentation.ui.feature.place_info

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.global.model.PlaceDetailViewModel
import com.example.dns.placesapp.presentation.mvp.feature.place_info.PlaceInfoPresenter
import com.example.dns.placesapp.presentation.mvp.feature.place_info.PlaceView
import com.example.dns.placesapp.presentation.ui.global.base.BaseFragment
import javax.inject.Inject
import javax.inject.Provider

class PlaceInfoFragment : BaseFragment(), PlaceView {

    @Inject
    lateinit var providePresenter: Provider<PlaceInfoPresenter>

    @InjectPresenter
    lateinit var presenter: PlaceInfoPresenter

    @ProvidePresenter
    fun providePresenter(): PlaceInfoPresenter = providePresenter.get()

    companion object {
        fun getInstance(model: PlaceDetailViewModel) = PlaceInfoFragment()
    }

    override fun layoutRes() = R.layout.fragment_place_info

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

    }
}
package com.example.dns.placesapp.presentation.ui.global.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.dns.placesapp.presentation.mvp.global.base.BaseView
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    abstract fun layoutRes(): Int

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(layoutRes(), container, false)

}
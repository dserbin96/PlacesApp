package com.example.dns.placesapp.presentation.ui.global.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.dns.placesapp.presentation.mvp.global.base.BaseView

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        //AndroidSupportInjection.inject(this)
    }

    abstract fun layoutRes(): Int

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(layoutRes(), container, false)

}
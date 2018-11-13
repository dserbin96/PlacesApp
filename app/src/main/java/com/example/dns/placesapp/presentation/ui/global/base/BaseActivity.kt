package com.example.dns.placesapp.presentation.ui.global.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.dns.placesapp.presentation.mvp.global.base.BaseView
import dagger.android.AndroidInjection

abstract class BaseActivity : MvpAppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initViews()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun initViews()
}
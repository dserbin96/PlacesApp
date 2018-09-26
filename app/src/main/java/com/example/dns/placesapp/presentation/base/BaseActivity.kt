package com.example.dns.placesapp.presentation.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.ProvidePresenter
import dagger.android.AndroidInjection
import javax.inject.Inject

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
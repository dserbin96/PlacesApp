package com.example.dns.placesapp.presentation.feature.main

import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_test.*

class MainActivity : BaseActivity<MainPresenter,MainView>(),MainView {

    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var presenter: MainPresenter

    override fun initViews() {

    }
    override fun getLayoutId() = R.layout.activity_main

    override fun onStart() {
        super.onStart()

        button.setOnClickListener {
            presenter.click()
        }
    }

    override fun showLoading() {
        pbTest.visibility = View.VISIBLE
    }

    override fun hideLoaging() {
        pbTest.visibility = View.GONE
    }

    override fun showMessage(message:String) {
        tvTest.text = message
    }

}

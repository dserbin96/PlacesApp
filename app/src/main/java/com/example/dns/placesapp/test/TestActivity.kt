package com.example.dns.placesapp.test

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.example.dns.placesapp.R
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : MvpAppCompatActivity(), TestView {

    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var presenter: TestPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }

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
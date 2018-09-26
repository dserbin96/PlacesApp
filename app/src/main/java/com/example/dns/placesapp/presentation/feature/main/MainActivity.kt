package com.example.dns.placesapp.presentation.feature.main

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var providePresenter: Provider<MainPresenter>

    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var presenter: MainPresenter

    @ProvidePresenter(type = PresenterType.GLOBAL)
    fun providePresenter(): MainPresenter = providePresenter.get()

    override fun initViews() {
        presenter.start()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    fun initBottomNavigation(){

    }

    override fun getLayoutId() = R.layout.activity_main

    override fun showLoading() {
    }

    override fun hideLoaging() {
    }

    override fun showMessage(message: String) {
    }

}

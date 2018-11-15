package com.example.dns.placesapp.presentation.ui.feature.main

import android.support.v4.content.ContextCompat
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.mvp.feature.main.MainPresenter
import com.example.dns.placesapp.presentation.mvp.feature.main.MainView
import com.example.dns.placesapp.presentation.ui.global.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : BaseActivity(), MainView, AHBottomNavigation.OnTabSelectedListener {

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
        initBottomNavigation()
        supportActionBar
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun getLayoutId() = R.layout.activity_main

    override fun showLoading() {
    }

    override fun hideLoaging() {
    }

    override fun showMessage(message: String) {

    }

    override fun onTabSelected(position: Int, wasSelected: Boolean): Boolean {
        presenter.navigateTo(position)
        return true
    }

    private fun initBottomNavigation() {
        with(btnNavigation) {
            setOnTabSelectedListener(this@MainActivity)
            titleState = AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE_FORCE
            accentColor = ContextCompat.getColor(this@MainActivity, R.color.colorPrimary)
            addItem(AHBottomNavigationItem(R.string.item_bottom_navigation_search, R.drawable.ic_search, android.R.color.white))
            addItem(AHBottomNavigationItem(R.string.item_bottom_navigation_places, R.drawable.ic_places, android.R.color.white))
            addItem(AHBottomNavigationItem(R.string.item_bottom_navigation_map, R.drawable.ic_map, android.R.color.white))
            currentItem = itemsCount - 1
        }
    }

}

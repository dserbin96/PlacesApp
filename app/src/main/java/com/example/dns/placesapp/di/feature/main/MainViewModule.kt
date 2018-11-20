package com.example.dns.placesapp.di.feature.main

import android.content.Intent
import android.support.v4.app.Fragment
import com.example.dns.placesapp.R
import com.example.dns.placesapp.di.global.scope.PerActivity
import com.example.dns.placesapp.presentation.mvp.global.MAPS
import com.example.dns.placesapp.presentation.mvp.global.PLACES
import com.example.dns.placesapp.presentation.mvp.global.PLACE_INFO
import com.example.dns.placesapp.presentation.mvp.global.SEARCH
import com.example.dns.placesapp.presentation.ui.feature.main.MainActivity
import com.example.dns.placesapp.presentation.ui.feature.maps.MapsFragment
import com.example.dns.placesapp.presentation.ui.feature.place_info.PlaceInfoFragment
import com.example.dns.placesapp.presentation.ui.feature.places.PlacessFragment
import com.example.dns.placesapp.presentation.ui.feature.search.SearchFragment
import com.example.dns.placesapp.presentation.ui.global.delegetes.LoaderDelegate
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.SupportAppNavigator

@Module
class MainViewModule {

    @PerActivity
    @Provides
    fun provideNavigator(activity: MainActivity): Navigator {
        return object : SupportAppNavigator(activity, R.id.conteiner) {

            override fun createActivityIntent(screenKey: String?, data: Any?): Intent? {
                return null
            }

            override fun createFragment(screenKey: String?, data: Any?): Fragment? =
                    when (screenKey) {
                        MAPS -> MapsFragment.getInstance()
                        PLACES -> PlacessFragment.getInstance()
                        SEARCH -> SearchFragment.getInstance()
                        PLACE_INFO -> PlaceInfoFragment.getInstance()
                        else -> MapsFragment.getInstance()
                    }

        }
    }

    @PerActivity
    @Provides
    fun provideLoaderDelegate(activity: MainActivity) =
            LoaderDelegate(activity.supportFragmentManager)

}
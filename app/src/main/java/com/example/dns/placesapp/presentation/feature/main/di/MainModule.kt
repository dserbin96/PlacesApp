package com.example.dns.placesapp.presentation.feature.main.di

import android.content.Intent
import android.support.v4.app.Fragment
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.feature.main.MainActivity
import com.example.dns.placesapp.presentation.feature.main.fragment.maps.MapsFragment
import com.example.dns.placesapp.util.MAPS
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.SupportAppNavigator

@Module
class MainModule {

    @Provides
    fun provideNavigator(activity: MainActivity): Navigator {
        return object : SupportAppNavigator(activity, R.id.conteiner) {

            override fun createActivityIntent(screenKey: String?, data: Any?): Intent? {
                return null
            }

            override fun createFragment(screenKey: String?, data: Any?): Fragment? =
                    when (screenKey) {
                        MAPS -> MapsFragment.getInstance()
                        else -> MapsFragment.getInstance()
                    }

        }
    }


}
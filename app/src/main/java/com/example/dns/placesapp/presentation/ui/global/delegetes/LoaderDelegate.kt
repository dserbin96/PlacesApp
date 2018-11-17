package com.example.dns.placesapp.presentation.ui.global.delegetes

import android.support.v4.app.FragmentManager
import com.example.dns.placesapp.presentation.ui.global.widgets.FragmentDialogLoader

class LoaderDelegate(private val fm: FragmentManager) {

    companion object {
        private const val NAME = "LoaderDelegate"
    }

    private val loaderDialog = FragmentDialogLoader()

    init {
        loaderDialog.isCancelable = false
    }

    fun showLoading() {
        if (!loaderDialog.isAdded) loaderDialog.show(fm, NAME)
    }

    fun hideLoading() {
        if (loaderDialog.isAdded) loaderDialog.dismiss()
    }

}
package com.example.dns.placesapp.presentation.mvp.global.error

import com.bumptech.glide.load.HttpException
import com.example.dns.placesapp.R
import com.example.dns.placesapp.domain.global.manager.ResourceManager
import java.io.IOException
import java.lang.ref.WeakReference
import javax.inject.Inject

class DefaultErrorHandler @Inject constructor(private val resourceManager: ResourceManager)
    : ErrorHandler {

    private lateinit var view: WeakReference<CanShowError>

    override fun proceed(error: Throwable) {
        val view = view.get()
                ?: throw IllegalStateException("View must be attachet to ErrorHandler")

        val message = when (error) {
            is HttpException -> when (error.statusCode) {
                400 -> resourceManager.getString(R.string.bad_request)
                else -> resourceManager.getString(R.string.uncnown_error)
            }
            is IOException -> resourceManager.getString(R.string.interner_not_connection)
            else -> resourceManager.getString(R.string.uncnown_error)
        }
        view.showError(message)
    }

    override fun attachView(view: CanShowError) {
        this.view = WeakReference(view)
    }

    override fun detachView() {
        this.view.clear()
    }
}
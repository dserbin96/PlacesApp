package com.example.dns.placesapp.data.network.interceptor

import android.annotation.SuppressLint
import okhttp3.Interceptor
import okhttp3.Response
import java.text.SimpleDateFormat
import java.util.*

class FoursquareInterceptor() : Interceptor {

    companion object {
        private const val CLIENT_ID_VALUE = "RBPHEXCTFO24Q0OFCZUJZUR3EXTGV3MBJKBFB0N43SD1WGGH"
        private const val CLIENT_SECRET_VALUE = "CDK14JW3GISUNNLO5LCK5F2Q0U0AMH1YM24UGYTIMO53VOUV"
        private const val CLIENT_ID_NAME = "client_id"
        private const val CLIENT_SECRET_NAME = "client_secret"
        private const val VERSION_NAME = "v"
    }

    @SuppressLint("SimpleDateFormat")
    override fun intercept(chain: Interceptor.Chain): Response {
        val version = SimpleDateFormat("yyyyMMdd").format(Date())

        var request = chain.request()
        val url = request.url()
                .newBuilder()
                .addQueryParameter(CLIENT_ID_NAME, CLIENT_ID_VALUE)
                .addQueryParameter(CLIENT_SECRET_NAME, CLIENT_SECRET_VALUE)
                .addQueryParameter(VERSION_NAME, version)
                .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
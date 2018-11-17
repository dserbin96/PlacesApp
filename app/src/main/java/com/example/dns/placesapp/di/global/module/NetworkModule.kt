package com.example.dns.placesapp.di.global.module

import com.example.dns.placesapp.data.network.FoursquareApi
import com.example.dns.placesapp.data.network.interceptor.FoursquareInterceptor
import com.example.dns.placesapp.di.global.scope.PerApplication
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class NetworkModule {

    val BASE_URL = " https://api.foursquare.com"

    @PerApplication
    @Provides
    @Named("HttpInterceptor")
    fun provideHttpLogInterceptor(): Interceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @PerApplication
    @Provides
    @Named("FoursquareInterceptor")
    fun provideFoursquareInterceptor(): Interceptor = FoursquareInterceptor()

    @PerApplication
    @Provides
    fun provideOkHttpClient(@Named("HttpInterceptor") httpInterceptor: Interceptor,
                            @Named("FoursquareInterceptor") foursquareInterceptor: Interceptor) =
            OkHttpClient.Builder()
                    .addInterceptor(httpInterceptor)
                    .addInterceptor(foursquareInterceptor)
                    .build()

    @PerApplication
    @Provides
    fun provideFoursquareApi(okHttpClient: OkHttpClient) =
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(okHttpClient)
                    .build()
                    .create(FoursquareApi::class.java)

}
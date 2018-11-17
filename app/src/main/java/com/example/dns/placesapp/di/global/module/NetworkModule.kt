package com.example.dns.placesapp.di.global.module

import com.example.dns.placesapp.data.network.FoursquareApi
import com.example.dns.placesapp.di.global.scope.PerApplication
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    val BASE_URL = " https://api.foursquare.com"

    @PerApplication
    @Provides
    fun provideHttpLogInterceptor(): Interceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @PerApplication
    @Provides
    fun provideOkHttpClient(interceptor: Interceptor) =
            OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

    @PerApplication
    @Provides
    fun provideRetrofinBuilder() =
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

    @PerApplication
    @Provides
    fun provideFoursquareApi(okHttpClient: OkHttpClient,
                             builder: Retrofit.Builder) =
            builder.client(okHttpClient)
                    .build()
                    .create(FoursquareApi::class.java)

}
package com.rapidlearner.goodworklabstask.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.viewbinding.BuildConfig
import com.rapidlearner.goodworklabstask.network.retrofit.ApiClient
import com.rapidlearner.goodworklabstask.network.retrofit.ApiInterface
import com.rapidlearner.goodworklabstask.network.retrofit.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else
            HttpLoggingInterceptor.Level.NONE
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideApiClient(apiInterface: ApiInterface): ApiClient {
        return ApiClient(apiInterface)
    }

    @Singleton
    @Provides
    fun provideConnectivityManager(application: Application): ConnectivityManager {
        return application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}
package com.rapidlearner.goodworklabstask.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rapidlearner.goodworklabstask.application.GoodWorkApplication
import com.rapidlearner.goodworklabstask.network.retrofit.ApiClient
import javax.inject.Inject

open class BaseActivity:AppCompatActivity() {
    @Inject
    lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GoodWorkApplication.getAppComponent().inject(this)
    }
}
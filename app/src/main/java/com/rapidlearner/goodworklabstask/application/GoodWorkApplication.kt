package com.rapidlearner.goodworklabstask.application

import android.app.Application
import android.content.Context
import com.rapidlearner.goodworklabstask.di.AppComponent
import com.rapidlearner.goodworklabstask.di.DaggerAppComponent
import com.rapidlearner.goodworklabstask.di.NetworkModule

class GoodWorkApplication:Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        //MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        appComponent = DaggerAppComponent.builder().networkModule(NetworkModule()).build()
    }

    companion object{
        lateinit var mInstance:GoodWorkApplication
        private lateinit var appComponent: AppComponent

      fun getAppContext() : Context{
            return mInstance
        }

        fun getAppInstance() : GoodWorkApplication{
            return mInstance
        }

        fun getAppComponent(): AppComponent {
            return appComponent
        }

    }
}
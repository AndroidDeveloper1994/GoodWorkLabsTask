package com.rapidlearner.goodworklabstask.di
import com.rapidlearner.goodworklabstask.view.activity.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    fun inject(baseActivity: BaseActivity)
}
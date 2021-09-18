package com.rapidlearner.goodworklabstask.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rapidlearner.goodworklabstask.network.retrofit.ApiClient
import com.rapidlearner.goodworklabstask.view.activity.BaseActivity
import com.rapidlearner.goodworklabstask.view.fragment.callback.FragmentCommunicationCallback
import java.lang.ref.WeakReference

open class BaseFragment:Fragment() {
    protected var switchFragmentCallback: WeakReference<FragmentCommunicationCallback>? = null
    protected lateinit var apiClient: ApiClient

    override fun onAttach(context: Context) {
        super.onAttach(context)
        apiClient = (context as BaseActivity).apiClient
        if(activity is FragmentCommunicationCallback){
            switchFragmentCallback  = WeakReference(activity as FragmentCommunicationCallback)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    open fun onSystemBackPressed(){
        val switchFragmentCallback = switchFragmentCallback?.get()
        if(switchFragmentCallback != null){
            switchFragmentCallback.onBackPress()
        }
    }
}
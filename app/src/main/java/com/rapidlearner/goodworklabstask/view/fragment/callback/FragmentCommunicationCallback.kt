package com.rapidlearner.goodworklabstask.view.fragment.callback

import androidx.fragment.app.Fragment

interface FragmentCommunicationCallback {
    fun switchFragment(fragment: Fragment?, addToBackStack: Boolean = false, replace: Boolean = true)
    fun onBackPress()
    fun popAllFragmentTill(tag: String? = null, include: Boolean = false)
    fun isFragmentExistInBackStack(tag: String?): Boolean
    fun isFragmentExist(tag: String?): Boolean
    fun refreshFragment(tag: String?)
}
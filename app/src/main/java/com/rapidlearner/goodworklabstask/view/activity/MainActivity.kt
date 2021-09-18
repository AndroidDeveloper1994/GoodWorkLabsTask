package com.rapidlearner.goodworklabstask.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rapidlearner.goodworklabstask.R
import com.rapidlearner.goodworklabstask.view.fragment.BaseFragment
import com.rapidlearner.goodworklabstask.view.fragment.PostFragmentView
import com.rapidlearner.goodworklabstask.view.fragment.callback.FragmentCommunicationCallback

class MainActivity : BaseActivity(), FragmentCommunicationCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        switchFragment(PostFragmentView())
    }

    override fun switchFragment(fragment: Fragment?, addToBackStack: Boolean, replace: Boolean) {
        fragment?.apply {
            supportFragmentManager.beginTransaction().let {

                it.replace(android.R.id.content, this, this::class.java.simpleName)

                if(addToBackStack) {
                    val tag = this::class.java.simpleName
                    it.addToBackStack(tag)
                }
                it.commitAllowingStateLoss()
            }
        }
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount == 0){
            finish()
        }else {
            val fragment = supportFragmentManager.fragments.lastOrNull()
            if(fragment == null){
                super.onBackPressed()
            }else {
                (fragment as BaseFragment).onSystemBackPressed()
            }
        }
    }

    override fun onBackPress() {
        if(supportFragmentManager.backStackEntryCount == 0){
            finish()
        }else{
            supportFragmentManager.popBackStackImmediate()
        }
    }

    override fun popAllFragmentTill(tag: String?, include: Boolean) {
    }

    override fun isFragmentExistInBackStack(tag: String?): Boolean {
        var isFound = false
        for(i in 0 until supportFragmentManager.backStackEntryCount) {
            isFound = tag?.equals(supportFragmentManager.getBackStackEntryAt(i).name)?:false
            if(isFound) {
                break
            }
        }

        return isFound
    }

    override fun isFragmentExist(tag: String?): Boolean {
        return supportFragmentManager.findFragmentByTag(tag) != null
    }

    override fun refreshFragment(tag: String?) {

    }
}
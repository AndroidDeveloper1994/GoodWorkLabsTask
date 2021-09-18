package com.rapidlearner.goodworklabstask.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ViewModelFactory<MType>(var viewModel: MType) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModel as T
    }

}
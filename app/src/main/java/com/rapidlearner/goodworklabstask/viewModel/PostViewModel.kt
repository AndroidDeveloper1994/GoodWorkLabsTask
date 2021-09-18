package com.rapidlearner.goodworklabstask.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rapidlearner.goodworklabstask.model.PostData
import com.rapidlearner.goodworklabstask.network.cororutineHelper.CoroutineRetrofitCaller
import com.rapidlearner.goodworklabstask.network.cororutineHelper.Resource
import com.rapidlearner.goodworklabstask.network.retrofit.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class PostViewModel(private val apiClient: ApiClient):BaseViewModel() {
   private val postMutableLiveData = MutableLiveData<Resource<PostData>>()

    fun loadPostData(){
        postMutableLiveData.value = Resource.loading(null)
        viewModelScope.launch {
            withContext(Dispatchers.IO){
            val response = CoroutineRetrofitCaller.safeApiCall(Dispatchers.IO){
             apiClient.getPostList(HashMap<String,Int>().apply {
                 put("page",1)
                 put("limit",20)
             })
            }
                withContext(Dispatchers.Main){
                if (response.data!!.isSuccessful){
                    postMutableLiveData.value = Resource.success(response.data.body())
                }else{
                    postMutableLiveData.value = Resource.error("something went wrong",null)
                }
                }
            }

        }
    }

     fun getPostData():LiveData<Resource<PostData>>{
        return postMutableLiveData
    }
}
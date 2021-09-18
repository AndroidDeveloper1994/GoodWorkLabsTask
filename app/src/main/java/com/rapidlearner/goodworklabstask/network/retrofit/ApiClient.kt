package com.rapidlearner.goodworklabstask.network.retrofit

import retrofit2.http.QueryMap

class ApiClient(private val apiInterface: ApiInterface) {

    suspend fun getPostList(@QueryMap queryMap:Map<String,@JvmSuppressWildcards Any>) = apiInterface.getPostList(queryMap)
}
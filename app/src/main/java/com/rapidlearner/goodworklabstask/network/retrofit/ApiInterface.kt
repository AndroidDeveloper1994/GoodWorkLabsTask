package com.rapidlearner.goodworklabstask.network.retrofit

import com.rapidlearner.goodworklabstask.model.Data
import com.rapidlearner.goodworklabstask.model.PostData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiInterface {

    @GET(URL_POST_LIST)
    suspend fun getPostList(@QueryMap queryMap:Map<String,@JvmSuppressWildcards Any>):Response<PostData>
}
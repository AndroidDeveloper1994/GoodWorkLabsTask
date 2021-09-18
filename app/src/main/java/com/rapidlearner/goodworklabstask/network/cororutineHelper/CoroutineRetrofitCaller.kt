package com.rapidlearner.goodworklabstask.network.cororutineHelper

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

object CoroutineRetrofitCaller {

    suspend fun <T> safeApiCall(dispatcher: CoroutineDispatcher, apiCall: suspend () -> T): Resource<T> {
        return withContext(dispatcher) {
            try {
                val result = apiCall.invoke()
                Resource.success(result)
            }catch (ex: Exception){
                Resource.error(ex.message.toString(),null)
            }
        }
    }
}
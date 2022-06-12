package com.navi.githubrepo.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .header("Authorization", "")
            .header("Accept", "application/vnd.github.v3+json")
            .build()
        return chain.proceed(newRequest)
    }
}
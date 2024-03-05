package com.example.storiesapp.data

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor(private val authToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .header("Authorization", "bearer $authToken")
            .build()
        return chain.proceed(modifiedRequest)
    }
}
package com.example.firstapp.data.api

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
            .newBuilder()
            .addHeader("X-Riot-Token", "RGAPI-752dc5fd-9041-4aac-a30a-ac428001fbae")
            .build())
    }
}

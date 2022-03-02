package com.example.firstapp.data.api

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
            .newBuilder()
            .addHeader("X-Riot-Token", "RGAPI-2e623a2b-c0bd-4478-b556-65f68bfd515d")
            .build())
    }
}

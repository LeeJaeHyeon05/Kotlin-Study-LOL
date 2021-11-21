package com.example.firstapp.fragment.build.retrofit

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitData: Application(){

    companion object {
        val BASE_URL ="http://ddragon.leagueoflegends.com"

        var networkService : NetworkService

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        init {
            networkService =retrofit.create(NetworkService::class.java)
        }
    }
}

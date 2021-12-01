package com.example.firstapp.data.api

import com.example.firstapp.model.ApiResponse
import com.example.firstapp.model.champion.ChampionVO
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/13
 **/
class FirstApi {

    val okHttpClient: OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BASIC)
                }
            )
            .build()


    val api: LeagueOfLegendsApi = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(LeagueOfLegendsApi::class.java)


    suspend fun getChampionInfo(): ApiResponse<ChampionVO> {
        api.getAllChampion().let {
            if (it.isSuccessful)
                return ApiResponse.Success(it.body()!!)
            else {
                return ApiResponse.Failure(Exception(it.message()))
            }
        }
    }

    companion object {
        const val API_URL = "http://ddragon.leagueoflegends.com/"
    }
}
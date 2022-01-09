package com.example.firstapp.data.api



import com.example.firstapp.model.mychampion.Champion
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET


interface BuildService {


    @GET("http://ddragon.leagueoflegends.com/cdn/11.23.1/data/ko_KR/champion.json")
    suspend fun fetchChampions(): ApiResponse<Champion>
}
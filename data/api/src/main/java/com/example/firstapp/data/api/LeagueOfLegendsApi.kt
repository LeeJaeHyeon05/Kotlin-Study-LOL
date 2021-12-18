package com.example.firstapp.data.api

import com.example.firstapp.model.champion.ChampionDetailVO
import com.example.firstapp.model.champion.ChampionVO
import retrofit2.Response
import retrofit2.http.GET


interface LeagueOfLegendsApi {
    //http://ddragon.leagueoflegends.com/cdn/11.23.1/data/en_US/champion.json
//    @GET("cdn/11.23.1/data/en_US/champion.json")
    @GET("cdn/11.23.1/data/en_US/champion/Aatrox.json")
    suspend fun getChampion(): Response<ChampionDetailVO>

    @GET("cdn/11.23.1/data/en_US/champion.json")
    suspend fun getAllChampion(): Response<ChampionVO>
}
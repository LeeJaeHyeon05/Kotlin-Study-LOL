package com.example.firstapp.data.api

import com.example.firstapp.model.champion.AatroxVO
import retrofit2.Response
import retrofit2.http.GET




interface LeagueOfLegendsApi {
    //http://ddragon.leagueoflegends.com/cdn/11.22.1/data/en_US/champion.json
//    @GET("cdn/11.22.1/data/en_US/champion.json")
    @GET("cdn/11.22.1/data/en_US/champion/Aatrox.json")
    suspend fun getChampion(): Response<AatroxVO>
}
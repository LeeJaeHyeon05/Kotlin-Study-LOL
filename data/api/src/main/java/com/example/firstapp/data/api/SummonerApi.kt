package com.example.firstapp.data.api

import com.example.firstapp.model.summoner.LeagueEntryDTO
import com.example.firstapp.model.summoner.SummonerDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SummonerApi {

    // 소환사명으로 검색
    @GET("/lol/summoner/v4/summoners/by-name/{summonerName}")
    suspend fun getSummonerDTOBySummonerName(@Path("summonerName") summonerName: String): Response<SummonerDTO>

    @GET("/lol/league/v4/entries/by-summoner/{encryptedSummonerId}")
    suspend fun getSummonerByEncryptedSummonerId(@Path("encryptedSummonerId") encryptedSummonerId: String): Response<List<LeagueEntryDTO>>

}
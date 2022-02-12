package com.example.firstapp.data.api

import com.example.firstapp.model.match.MatchDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MatchApi {

    @GET("/lol/match/v5/matches/by-puuid/{puuid}/ids")
    suspend fun getMatchIds(@Path("puuid") puuid: String): Response<List<String>>

    @GET("/lol/match/v5/matches/{matchId}")
    suspend fun getMatch(@Path("matchId") matchId: String): Response<MatchDto>

}